package com.qly.util;

import com.codahale.metrics.ExponentiallyDecayingReservoir;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import org.eclipse.jetty.util.annotation.Name;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;

/**
 * Created by Fanyi on 15/10/2.
 */
public class InstrumentedThreadPool extends QueuedThreadPool {
    private MetricRegistry registry;
    private String poolName;

    public Meter rejectedTasks;
    public Histogram queueSize;
    Histogram idleThreads;
    Histogram activeThreads;


    private void initMetrics() {

        // Generic
        rejectedTasks = registry.meter(MetricRegistry.name(
                InstrumentedThreadPool.class, poolName + "rejectedRequests"));

        Histogram idleThreadsHistogram = new Histogram(new ExponentiallyDecayingReservoir());
        idleThreads = registry.register(MetricRegistry.name(poolName, "idleThreads"), idleThreadsHistogram);

        Histogram activeThreadsHistogram = new Histogram(new ExponentiallyDecayingReservoir());
        activeThreads = registry.register(MetricRegistry.name(poolName, "activeThreads"), activeThreadsHistogram);

        // Server Queue size
        Histogram queueSizehistogram = new Histogram(new ExponentiallyDecayingReservoir());
        queueSize = registry.register(MetricRegistry.name(poolName, "queueSize"), queueSizehistogram);
    }


    public InstrumentedThreadPool(MetricRegistry registry, String poolName)
    {
        super();
        this.registry = registry;
        this.poolName = poolName;
        setName(poolName);
        initMetrics();
    }

    public InstrumentedThreadPool(@Name("maxThreads") int maxThreads, MetricRegistry registry, String poolName)
    {
        super(maxThreads);
        this.registry = registry;
        this.poolName = poolName;
        setName(poolName);
        initMetrics();
        idleThreads.update(getIdleThreads());
        activeThreads.update(getThreads() - getIdleThreads());
        queueSize.update(getQueueSize());
    }

    public InstrumentedThreadPool(@Name("maxThreads") int maxThreads,  @Name("minThreads") int minThreads, MetricRegistry registry, String poolName)
    {
        super(maxThreads, minThreads);
        this.registry = registry;
        this.poolName = poolName;
        setName(poolName);
        initMetrics();
        idleThreads.update(getIdleThreads());
        activeThreads.update(getThreads() - getIdleThreads());
        queueSize.update(getQueueSize());
    }

    public InstrumentedThreadPool(@Name("maxThreads") int maxThreads,  @Name("minThreads") int minThreads, @Name("idleTimeout")int idleTimeout, MetricRegistry registry, String poolName)
    {
        super(maxThreads, minThreads, idleTimeout);
        this.registry = registry;
        this.poolName = poolName;
        setName(poolName);
        initMetrics();
        idleThreads.update(getIdleThreads());
        activeThreads.update(getThreads() - getIdleThreads());
        queueSize.update(getQueueSize());
    }

    public InstrumentedThreadPool(@Name("maxThreads") int maxThreads, @Name("minThreads") int minThreads, @Name("idleTimeout") int idleTimeout, @Name("queue") BlockingQueue<Runnable> queue, MetricRegistry registry, String poolName)
    {
        super(maxThreads, minThreads, idleTimeout, queue);
        this.registry = registry;
        this.poolName = poolName;
        setName(poolName);
        initMetrics();
        idleThreads.update(getIdleThreads());
        activeThreads.update(getThreads() - getIdleThreads());
        queueSize.update(getQueueSize());
    }

    @Override
    public void execute(Runnable job)
    {
        idleThreads.update(getIdleThreads());
        activeThreads.update(getThreads() - getIdleThreads());
        queueSize.update(getQueueSize());
        try {
            super.execute(job);
        } catch (RejectedExecutionException e) {
            rejectedTasks.mark();
            throw e;
        }
    }

}
