package com.qly;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import com.qly.inject.BindJerseyModule;
import com.qly.inject.BindMybatisModule;
import com.qly.util.Instrumentation;
import com.qly.util.InstrumentedThreadPool;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.BlockingArrayQueue;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.EnumSet;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Hello world!
 */
public class MainServer {
    private Server dataServer;
    private Server metricsServer;


    private static final String CONFIG_KEY = "qly-server-config";
    public static AtomicBoolean initializationComplete = new AtomicBoolean(false);

    // 64 is currently the value of HttpClient queue also
    private static final int JETTY_QUEUE_CAPACITY = 64;
    private static final int JETTY_QUEUE_GROWTH_FACTOR = 0;
    private static final int JETTY_QUEUE_MAXSIZE = 64;
    private static final int NUM_CORES = Runtime.getRuntime().availableProcessors();
    // Number of selectors = number of cores
    // Number of acceptors = 1 + (Number of cores % 8)
    private static final int JETTY_MIN_THREADS = (NUM_CORES * 2) + (NUM_CORES + ((NUM_CORES % 8) + 1));
    private static final int JETTY_MAX_THREADS = JETTY_MIN_THREADS;
    private static final int JETTY_THREAD_TIMEOUT_MS = 60000;

    public static final BlockingArrayQueue<Runnable> JETTY_BLOCKING_QUEUE = new BlockingArrayQueue<Runnable>(
            JETTY_QUEUE_CAPACITY, JETTY_QUEUE_GROWTH_FACTOR, JETTY_QUEUE_MAXSIZE);

    public static Properties configProperties = new Properties();
    public static Properties urlConfigProperties = new Properties();
    private static Logger logger;

    /**
     * Convenience constructor with hostname and port.
     *
     * @param configs
     * @throws Exception
     */
    public MainServer(Properties configs) throws Exception {
        String hostname = configs.getProperty("server.listeningAddress");
        int apiPort = Integer.valueOf(configs.getProperty("server.apiPort"));
        InetSocketAddress addr = new InetSocketAddress(hostname, apiPort);
        dataServer = initDataServer(addr);
        //metricsServer = initMetricsServer(addr);
    }

    public MainServer() {
    }

    public void start() throws Exception {
        dataServer.start();
        //metricsServer.start();

        initializationComplete.set(true);
    }

    public void stop() throws Exception {
        for (Connector connector : dataServer.getConnectors()) {
            connector.stop();
        }
        for (Connector connector : metricsServer.getConnectors()) {
            connector.stop();
        }

        dataServer.stop();
        //metricsServer.stop();
    }

    public void join() throws Exception {
        dataServer.join();
        //metricsServer.join();
    }

    public static void main(String[] args) {
        try {
            FileInputStream configStream = new FileInputStream(System.getProperty(CONFIG_KEY,
                    "./conf/qly-service-config-local.cfg"));
            configProperties.load(configStream);
            configStream.close();
            logger = EnvironmentConfigurator.setup(configProperties);

            logger.info("Starting service");
            MainServer mainServer = new MainServer(configProperties);

            mainServer.start();
            mainServer.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }


    // ====================================== HELPER METHODS AND CLASSES =============================================
    public static class EnvironmentConfigurator {
        private static final String DEFAULT_LOGS_FOLDER = "../../logs/";
        private static final String DEFAULT_THREADPOOL_SIZE = "100";
        private static final String LOG_KEY = "slf4jConfig";

        static Logger logger = null;
        private static Properties sConfigProperties;

        public static Logger setup(Map<String, Object> configMap) throws IOException {
            Properties configProperties = new Properties();
            for (String key : configMap.keySet()) {
                configProperties.setProperty(key, (String) configMap.get(key));
            }
            return setup(configProperties);
        }

        public static Properties getProperties() {

            return sConfigProperties;
        }

        public static Logger setup(Properties configProperties) throws IOException {
            sConfigProperties = configProperties;

            String logsFolder = configProperties.getProperty("logsFolder");
            if (logsFolder == null) {
                logsFolder = DEFAULT_LOGS_FOLDER;
                // Cannot use the logger yet as I need the logsFolder property
                // to set it up
                System.out.println("Unable to read the logs folder path");
            }
            System.setProperty("logsFolder", logsFolder);

            //todo: add slf4j config file init
            //DOMConfigurator.configure(configProperties.getProperty(LOG_KEY));
            logger = LoggerFactory.getLogger(EnvironmentConfigurator.class.getName());

            String numThreads = configProperties.getProperty("numThreads");
            if (numThreads == null) {
                numThreads = DEFAULT_THREADPOOL_SIZE;
                System.out.println("Unable to read the threadpool size");
            }
            System.setProperty("numThreads", numThreads);

            System.out.println("============== Server Configuration Parameters ==============================");
            System.out.println("server.listeningAddress: " + configProperties.getProperty("server.listeningAddress"));
            System.out.println("server.apiPort: " + configProperties.getProperty("server.apiPort"));
            System.out.println("numThreads: " + numThreads);

            return logger;
        }
    }

    public static Server initDataServer(InetSocketAddress addr) throws Exception {
        Server server = new Server(addr);
        Boolean ssl = Boolean.valueOf(configProperties.getProperty("server.ssl"));

        // Add connectors
        if (ssl) {
            Connector sslConnector = createSSLConnector(server);
            server.setConnectors(new Connector[]{sslConnector});
        } else {
            Connector httpConnector = createHttpConnector(server);
            server.setConnectors(new Connector[]{httpConnector});
        }

        /*
        Boolean enableDoc = Boolean.valueOf(configProperties.getProperty("enableDoc", "true"));
        if (enableDoc) {
            handlers.addHandler(initDocumentationHandler());
            handlers.addHandler(initSwaggerServlet());
        }
        */

        ServletContextHandler context = new ServletContextHandler(server, "/",
                ServletContextHandler.NO_SESSIONS);
        EnumSet<DispatcherType> allType = EnumSet.of(DispatcherType.ASYNC, DispatcherType.ERROR, DispatcherType.FORWARD,
                DispatcherType.INCLUDE, DispatcherType.REQUEST);
        context.addFilter(GuiceFilter.class, "/*", allType);
        context.addServlet(DefaultServlet.class, "/");

        Injector injector = Guice.createInjector (
                new BindJerseyModule(),
                new BindMybatisModule()
        );

        return server;
    }

    private static ServerConnector createSSLConnector(Server server) {
        SslContextFactory sslContextFactory = new SslContextFactory();
        sslContextFactory.setKeyStorePath("../etc/keystore");
        sslContextFactory.setKeyStorePassword("password");
        sslContextFactory.setKeyManagerPassword("password");
        sslContextFactory.setTrustStorePath("../etc/keystore");
        sslContextFactory.setTrustStorePassword("password");
        HttpConfiguration https = new HttpConfiguration();
        https.addCustomizer(new SecureRequestCustomizer());

        InstrumentedThreadPool executor = new InstrumentedThreadPool(JETTY_MAX_THREADS, JETTY_MIN_THREADS,
                JETTY_THREAD_TIMEOUT_MS, JETTY_BLOCKING_QUEUE, Instrumentation.METRIC_REGISTRY, "JettyServerThreadPool");
        ServerConnector sslConnector = new ServerConnector(server, executor, null, null, -1, -1,
                new SslConnectionFactory(sslContextFactory, "http/1.1"), new HttpConnectionFactory());
        sslConnector.setIdleTimeout(60000);
        sslConnector.setPort(8443);
        return sslConnector;
    }

    public static ServerConnector createHttpConnector(Server server) {
        InstrumentedThreadPool executor = new InstrumentedThreadPool(JETTY_MAX_THREADS, JETTY_MIN_THREADS,
                JETTY_THREAD_TIMEOUT_MS, JETTY_BLOCKING_QUEUE, Instrumentation.METRIC_REGISTRY, "JettyServerThreadPool");
        ServerConnector httpConnector = new ServerConnector(server, executor, null, null, -1, -1,
                new HttpConnectionFactory());
        httpConnector.setIdleTimeout(60000);
        httpConnector.setPort(Integer.valueOf(configProperties.getProperty("server.apiPort")));
        return httpConnector;
    }






}
