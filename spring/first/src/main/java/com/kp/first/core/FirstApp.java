package com.kp.first.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication @EnableMongoRepositories(basePackages = "com.kp.first")
@ComponentScan(basePackages = "com.kp.first") public class FirstApp
    extends SpringBootServletInitializer {

    @Override protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FirstApp.class);
    }

    public static void main(String[] args) {
        System.out.println("Starting FirstApp");

        SpringApplication.run(FirstApp.class, args);
    }

}
