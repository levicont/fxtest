package com.lvg.fxtest.obslists;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.util.Callback;
import org.apache.log4j.Logger;

/**
 * Created by Victor Levchenko LVG Corp. on 19.12.16.
 */
public class CallbackListSample {
    private static final Logger LOGGER = Logger.getLogger(CallbackListSample.class);

    public static void main(String[] args) {

        Callback<IntegerProperty, Observable[]> callback = (IntegerProperty p) ->{
            LOGGER.info("In callback method p has value: "+p.getValue());
            return new Observable[]{p};
        };


        ObservableList<IntegerProperty> list = FXCollections.observableArrayList(callback);

        IntegerProperty p1 = new SimpleIntegerProperty(100);
        IntegerProperty p2 = new SimpleIntegerProperty(200);

        list.addAll(p1, p2);

        list.addListener(CallbackListSample::onChange);
        p1.set(500);

        list.add(new SimpleIntegerProperty(800));
        p1 = list.get(2);

        p1.set(1000);
    }

    public static void onChange(ListChangeListener.Change<? extends IntegerProperty> change){
        LOGGER.info("List has changed!");
    }
}
