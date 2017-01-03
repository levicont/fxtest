package com.lvg.fxtest.bounds;

import javafx.application.Application;
import javafx.beans.binding.When;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by Victor Levchenko LVG Corp. on 03.01.17.
 */
public class SlidingLeftNodeSample extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button btVisible = new Button();
        btVisible.setOnAction(e -> b2.setVisible(!b2.isVisible()));

        btVisible.textProperty().bind(new When(b2.visibleProperty())
                .then("Make Invisible")
                .otherwise("Make Visible"));
        b2.managedProperty().bind(b2.visibleProperty());

        HBox root = new HBox();
        root.getChildren().addAll(btVisible, b1, b2, b3);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
