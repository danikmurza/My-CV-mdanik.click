package com.example.angularspring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ApplicationConfiguration {
    private static final Logger log = LoggerFactory.getLogger(ApplicationConfiguration.class);
    @Value("${server.port}")
    private int port;

    @PostConstruct
    public void init(){
        log.warn("App is loaded!  -----  " + port);
    }
}
