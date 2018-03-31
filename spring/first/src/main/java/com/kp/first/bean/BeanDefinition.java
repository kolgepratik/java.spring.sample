package com.kp.first.bean;

import com.mongodb.MongoCredential;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BeanDefinition {

    @Bean public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

    @Bean public MongoClientFactoryBean mongo() {
        // mongodb://kolgepratik:kolgepratik@ds263408.mlab.com:63408/dbone

        final String DB_PASSWORD = "kolgepratik";
        final String DB_NAME = "dbone";
        final String DB_HOST = "ds263408.mlab.com";
        final Integer DB_PORT = 63408;
        final String DB_USERNAME = "kolgepratik";

        MongoCredential credential = MongoCredential
                .createCredential(DB_USERNAME, DB_NAME, DB_PASSWORD.toCharArray());

        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost(DB_HOST);
        mongo.setPort(DB_PORT);
        mongo.setCredentials(new MongoCredential[] {credential});

        return mongo;
    }

}
