package com.kp.first.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration public class ContextPathConfig
    implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    private final String CONTEXT_PATH = "/first";
    private final Integer PORT_NUMBER = 8080;

    @Override public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setContextPath(CONTEXT_PATH);
        factory.setPort(PORT_NUMBER);
    }
}
