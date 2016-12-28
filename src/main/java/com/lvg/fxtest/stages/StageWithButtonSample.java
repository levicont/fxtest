package com.lvg.fxtest.stages;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.log4j.Logger;

/**
 * Created by Victor on 28.12.2016.
 */
public class StageWithButtonSample extends Application{
    private static final Logger LOGGER = Logger.getLogger(StageWithButtonSample.class);


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label styleLabel = new Label("Stage Style");

        Button button = new Button("Button");
        button.setOnAction( e -> primaryStage.close());

        VBox root = new VBox();
        root.getChildren().addAll(styleLabel, button);

        Scene scene = new Scene(root, 300, 100);

        primaryStage.setScene(scene);

        //show(primaryStage, styleLabel, StageStyle.DECORATED);
      // show(primaryStage, styleLabel, StageStyle.UNDECORATED);
      // show(primaryStage, styleLabel, StageStyle.UNIFIED);
      // show(primaryStage, styleLabel, StageStyle.UTILITY);
       show(primaryStage, styleLabel, StageStyle.TRANSPARENT);

    }

    private void show(Stage stage, Label styleLabel, StageStyle style){
        styleLabel.setText(style.toString());

        stage.initStyle(style);

        if(style == StageStyle.TRANSPARENT){
            stage.getScene().setFill(null);
            stage.getScene().getRoot().setStyle("-fx-background-color : transparent");
        }else if (style == StageStyle.UNIFIED){
            stage.getScene().setFill(Color.TRANSPARENT);
        }

        stage.show();
    }



}
