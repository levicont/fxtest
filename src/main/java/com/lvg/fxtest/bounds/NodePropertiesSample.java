package com.lvg.fxtest.bounds;

import javafx.application.Application;
import javafx.collections.ObservableMap;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

/**
 * Created by Victor Levchenko LVG Corp. on 03.01.17.
 */
public class NodePropertiesSample extends Application {
    private static final Logger LOGGER = Logger.getLogger(NodePropertiesSample.class);

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();

        TextField txfName = new TextField();

        Button btShowProps = new Button("Show props");
        btShowProps.setOnAction(e -> txfName.setText(txfName.getProperties().get("valid.count")+""));

        root.getChildren().addAll(txfName, btShowProps);

        LOGGER.info("Properties of txfName before getProps: "+ txfName.hasProperties());
        ObservableMap<Object, Object> props = txfName.getProperties();
        props.put("valid.count", "Must be least 100");
        LOGGER.info("Properties of txfName before getProps: "+ txfName.hasProperties());

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
