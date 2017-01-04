package com.lvg.fxtest.mongo.twitterarch;

import org.apache.log4j.Logger;
import twitter4j.*;

import java.util.List;

/**
 * Created by Victor on 04.01.2017.
 */
public class TwitterSearchSample {
    private static final Logger LOGGER = Logger.getLogger(TwitterSearchSample.class);

    public static void main(String[] args) {
        LOGGER.info("Starting search 'MongoDB'");
        Twitter twitter = TwitterFactory.getSingleton();
        try{
            Query query = new Query("MongoDB Java");
            QueryResult result;
            do{
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status status : tweets){
                    LOGGER.info("@"+status.getUser().getScreenName()+": "+status.getText());
                }

            }while ((query = result.nextQuery()) != null);
        }catch (TwitterException ex){
            LOGGER.warn("Exception: "+ex.getMessage());

        }
    }
}
