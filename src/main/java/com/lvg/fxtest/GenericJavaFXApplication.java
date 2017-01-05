package com.lvg.fxtest;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

/**
 * Created by Victor on 05.01.2017.
 */
public class GenericJavaFXApplication extends Application{
    protected static final Logger LOGGER = Logger.getLogger(GenericJavaFXApplication.class);
    protected Scene scene;
    protected Parent root;


    @Override
    public void start(Stage primaryStage) throws Exception {
        LOGGER.info("Starting FX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        root = new VBox();
        scene = new Scene(root, 500, 400);
    }
}
