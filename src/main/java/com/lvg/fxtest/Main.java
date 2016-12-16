package com.lvg.fxtest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.log4j.Logger;


public class Main extends Application{
    private static final Logger LOG = Logger.getLogger(Main.class);
    private VBox root;

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        LOG.info("STARTING FX APPLICATION");
        Scene scene = new Scene(root,500,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        LOG.info("INITIALIZING FX APPLICATION");
        root = new VBox();
    }


}
