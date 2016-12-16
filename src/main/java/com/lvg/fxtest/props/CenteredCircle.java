package com.lvg.fxtest.props;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class CenteredCircle extends Application{
    private static final Logger LOGGER = Logger.getLogger(CenteredCircle.class);
    private Circle circle;


    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        LOGGER.info("STARTING FX APPLICATION");
        Group root = new Group(circle);
        Scene scene = new Scene(root, 100, 100);

        circle.centerXProperty().bind(scene.widthProperty().divide(2));
        circle.centerYProperty().bind(scene.heightProperty().divide(2));
        circle.radiusProperty().bind(Bindings.min(scene.widthProperty(), scene.heightProperty()).divide(2));

        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        LOGGER.info("INITIALIZING FX APPLICATION");
        circle = new Circle();
    }
}
