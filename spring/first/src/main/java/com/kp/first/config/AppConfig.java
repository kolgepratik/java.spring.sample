package com.kp.first.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@ComponentScan(basePackages = {"com.kp.first"})
@EnableRedisRepositories (basePackages = {"com.kp.first.repository"})
public class AppConfig {
}
