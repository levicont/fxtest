package com.lvg.fxtest.mongo.m101j.finalq7;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.HashSet;
import java.util.Set;

public class OrphanRemover {
    private static final Logger LOGGER = Logger.getLogger(OrphanRemover.class);

    public static void main(String[] args) {
        LOGGER.info("Get connection to MongoDB");
        MongoClient client = new MongoClient("localhost", 27017);
        LOGGER.info("Get connection to users DB");
        MongoDatabase db = client.getDatabase("test");

        MongoCollection<Document> images = db.getCollection("images");
        MongoCollection<Document> albums = db.getCollection("albums");

        Set<Document> unOrphanImages = new HashSet<>();

        for (Document image : images.find()){
            Bson filter = Filters.eq("images",image.getInteger("_id"));
            if(!albums.find(filter).iterator().hasNext()){
                unOrphanImages.add(image);
            }
        }

        for (Document image : unOrphanImages){
            images.deleteOne(image);
            System.out.println(image.getInteger("_id"));
        }
        System.out.println("Result size = "+ unOrphanImages.size());

    }
}
