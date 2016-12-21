package com.lvg.fxtest.mongo;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.Logger;
import org.bson.Document;

public class MongoTest {
    private static final Logger LOGGER = Logger.getLogger(MongoTest.class);


    public static void main(String[] args) {
        LOGGER.info("Get connection to MongoDB");
        MongoClient client = new MongoClient("localhost", 27017);
        LOGGER.info("Get connection to users DB");
        MongoDatabase db = client.getDatabase("users");

        MongoCollection<Document> users = db.getCollection("users");
        for (Document user : users.find()){
            System.out.println(user.toJson());
        }

        client.close();
    }
}
