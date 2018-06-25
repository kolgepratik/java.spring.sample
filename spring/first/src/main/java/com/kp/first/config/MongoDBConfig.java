package com.kp.first.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration public class MongoDBConfig extends AbstractMongoConfiguration {

    private final String DB_NAME = "dbone";

    @Autowired private Mongo mongo;

    @Override protected String getDatabaseName() {
        return DB_NAME;
    }

    @Override public MongoClient mongoClient() {
        return (MongoClient) mongo;
    }
}
