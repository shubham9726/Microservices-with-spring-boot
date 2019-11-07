package com.example.studentdata.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Mongo Configuration
 */
@Configuration
class MongoConfiguration extends AbstractMongoConfiguration {

    @Value("${mongodb.uri}")
    private String mongodbUri;

    @Value("${mongodb.database}")
    private String databaseName;

    @Value("${mongodb.port}")
    private int dbPort;

    @Override
    @Bean
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI(mongodbUri));
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }

    @Bean
    public int getDbPort() {
        return dbPort;
    }
}
