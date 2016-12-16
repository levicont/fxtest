package com.lvg.fxtest.obslists;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;


public class ListInvalidationSample {
    private static final Logger LOGGER = Logger.getLogger(ObservableListsSample.class);

    public static void main(String[] args) {
        ObservableList<String> list = FXCollections.observableArrayList("one", "two");
        list.addListener(ListInvalidationSample::invalidated);

        LOGGER.info("Before adding three");
        list.add("three");
        LOGGER.info("After adding three");

        LOGGER.info("Before adding four and five");
        list.addAll("four", "five");
        LOGGER.info("After adding four and five");

        LOGGER.info("Before replacing one with one");
        list.set(0, "one");
        LOGGER.info("After replacing one with one");

    }

    public static void invalidated(Observable list){
        LOGGER.info("List is invalid");
    }
}
