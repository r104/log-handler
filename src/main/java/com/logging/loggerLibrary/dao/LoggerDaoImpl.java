package com.logging.loggerLibrary.dao;

import com.logging.loggerLibrary.model.Message;
import com.mongodb.MongoClient;
import org.bson.Document;

public class LoggerDaoImpl implements LoggerDao{

    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

    @Override
    public void insert(Message log) {

        Document doc = new Document("1", log.toString());
        mongoClient.getDatabase("log").getCollection("logger").insertOne(doc);
    }

}
