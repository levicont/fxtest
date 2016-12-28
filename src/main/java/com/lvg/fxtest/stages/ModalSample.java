package com.lvg.fxtest.stages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import org.apache.log4j.Logger;

/**
 * Created by Victor on 28.12.2016.
 */
public class ModalSample extends Application{

    private static final Logger LOGGER = Logger.getLogger(ModalSample.class);

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Press to drug");

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> stage.close());

        Button ownedNoneButton = new Button("Owned NONE");
        ownedNoneButton.setOnAction(e -> showDialog(stage, Modality.NONE));

        Button ownedWindowModalButton = new Button("Window Modal");
        ownedWindowModalButton.setOnAction(e -> showDialog(stage, Modality.WINDOW_MODAL));


        VBox root = new VBox();
        root.getChildren().addAll(label, closeButton, ownedNoneButton, ownedWindowModalButton);

        Scene scene = new Scene(root, 400, 200);

        stage.setScene(scene);
        stage.setTitle("Moving a stage");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    private void showDialog(Window owner, Modality modality){
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label label = new Label(modality.toString());
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> stage.close());

        VBox root = new VBox();
        root.getChildren().addAll(label, closeButton);

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.setTitle("A Dialog Box");
        stage.show();

    }

}
