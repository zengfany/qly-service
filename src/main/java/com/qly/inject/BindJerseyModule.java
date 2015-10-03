package com.qly.inject;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.eclipse.jetty.servlet.DefaultServlet;

import java.util.HashMap;

/**
 * Created by Fanyi on 15/10/3.
 */
public class BindJerseyModule extends ServletModule {

    @Override
    protected void configureServlets() {
        bind(DefaultServlet.class).in(Singleton.class);
        //bind jersey resources
        ResourceConfig rc = new PackagesResourceConfig( "com.qly.service.api.v1");
        for (Class<?> resource : rc.getClasses()) {
            bind(resource);
        }
        bind(JacksonJsonProvider.class).in(Singleton.class);
        //bind(MessageBodyReader.class).to(JacksonJsonProvider.class).in(Singleton.class);
        //bind(MessageBodyWriter.class).to(JacksonJsonProvider.class).in(Singleton.class);
        HashMap<String, String> initParams = new HashMap<String, String>();
        //initParams.put("jersey.config.server.provider.packages", "com.fasterxml.jackson.jaxrs.json");
        //initParams.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
        serve("/*").with(GuiceContainer.class, initParams);
    }
}
