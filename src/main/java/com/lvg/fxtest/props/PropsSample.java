package com.lvg.fxtest.props;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.When;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.apache.log4j.Logger;

/**
 * Created by Victor Levchenko LVG Corp. on 14.12.16.
 */
public class PropsSample {
    private static final Logger LOGGER = Logger.getLogger(PropsSample.class);

    public static void main(String[] args) {
        IntegerProperty x = new SimpleIntegerProperty(100);
        IntegerProperty y = new SimpleIntegerProperty(200);
        IntegerProperty z = new SimpleIntegerProperty(300);

        NumberBinding sum = x.add(y).add(z);


        LOGGER.info("sum = "+ sum.getValue());
        LOGGER.info("set x = 500");
        x.set(500);
        LOGGER.info("sum = "+ sum.getValue());
        LOGGER.info("Creating boolean binding x == y");
        BooleanBinding booleanBinding = x.isEqualTo(y);
        LOGGER.info("Boolean binding x == y is: "+booleanBinding.get());
        LOGGER.info("set x = 200");
        x.set(200);
        LOGGER.info("Boolean binding x == y is: "+booleanBinding.get());

        IntegerProperty num = new SimpleIntegerProperty(10);
        StringBinding stringBinding = new When(x.isEqualTo(y)).then("Equal").otherwise("Not equal");
        LOGGER.info("Boolean binding x == y is: "+stringBinding.get());


    }
}
