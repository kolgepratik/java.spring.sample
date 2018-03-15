package com.kp.first.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;

@Configuration public class MongoDBConfig extends AbstractMongoConfiguration {

    private final String DB_NAME = "dbone";
    private final String DB_HOST = "ds263408.mlab.com";
    private final Integer DB_PORT = 63408;
    private final String DB_USERNAME = "kolgepratik";
    private final String DB_PASSWORD = "kolgepratik";

    // mongodb://kolgepratik:kolgepratik@ds263408.mlab.com:63408/dbone

    @Autowired private Mongo mongo;

    @Override protected String getDatabaseName() {
        return DB_NAME;
    }

    @Override public MongoClient mongoClient() {
        return (MongoClient) mongo;
    }

    @Bean public MongoClientFactoryBean mongo() {
        MongoCredential credential = MongoCredential
            .createCredential(DB_USERNAME, getDatabaseName(), DB_PASSWORD.toCharArray());

        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost(DB_HOST);
        mongo.setPort(DB_PORT);
        mongo.setCredentials(new MongoCredential[] {credential});

        return mongo;
    }

}
