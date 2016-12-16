package com.lvg.fxtest.obslists;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;


public class ObservableListsSample {
    private static final Logger LOGGER = Logger.getLogger(ObservableListsSample.class);

    public static void main(String[] args) {
        ObservableList<String> list = FXCollections.observableArrayList("one", "two");
        LOGGER.info("After creating list: "+list);

        list.addAll("three", "four");
        LOGGER.info("After adding elements: "+list);

        list.remove(1,3);
        LOGGER.info("After removing elements: "+list);

        list.retainAll("one");
        LOGGER.info("After retaining \"one\" : "+list);

        ObservableList<String> list2 = FXCollections.<String>observableArrayList("1", "2", "3");
        list.setAll(list2);
        LOGGER.info("After setting list2 to list : "+list);

        ObservableList<String> list3 = FXCollections.<String>observableArrayList("one", "two", "three");

        ObservableList<String> list4 = FXCollections.<String>concat(list2, list3);
        LOGGER.info("list2 is "+list2);
        LOGGER.info("list3 is "+list3);
        LOGGER.info("After concatenating list2 and list3: "+list4);

    }
}
