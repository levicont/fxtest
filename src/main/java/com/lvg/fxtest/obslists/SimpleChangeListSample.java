package com.lvg.fxtest.obslists;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

/**
 * Created by Victor Levchenko LVG Corp. on 19.12.16.
 */
public class SimpleChangeListSample {
    private static final Logger LOGGER = Logger.getLogger(SimpleChangeListSample.class);

    public static void main(String[] args) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addListener(SimpleChangeListSample::onChanged);

        list.addAll("one","two","three");

        list.removeAll("one","three");



    }

    public static void onChanged(ListChangeListener.Change<? extends String> change){
        LOGGER.info("List has changed!");
        while(change.next()){
            if (change.wasPermutated()){
                LOGGER.info("List was permuted");
            }else if(change.wasUpdated()){
                LOGGER.info("List was updated");

            }else if(change.wasReplaced()){
                LOGGER.info("List was replaced");

            }else {
                if (change.wasAdded()){
                    LOGGER.info("List was added");

                }else if (change.wasRemoved()){
                    LOGGER.info("List was removed");
                }
            }
        }
    }
}
