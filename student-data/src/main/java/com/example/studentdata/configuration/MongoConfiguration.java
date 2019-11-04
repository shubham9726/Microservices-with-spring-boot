package com.example.studentdata.configuration;


import com.example.studentdata.properties.MongoProperties;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Mongo Config
 */
class MongoConfiguration extends AbstractMongoConfiguration {


    private MongoProperties mongoProperties;

    @Autowired
    public MongoConfiguration(MongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    @Bean
    @Override
    public MongoClient mongoClient() {
        System.out.println("qweweqwqweqw");
        return new MongoClient(new MongoClientURI(mongoProperties.getMongoUri()));
    }

    @Override
    protected String getDatabaseName() {
        System.out.println("fxcgbhgjfghg");
        return mongoProperties.getMongoDatabase();
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        System.out.println("shuhbhamm");
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }
}