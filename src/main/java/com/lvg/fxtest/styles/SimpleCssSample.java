package com.lvg.fxtest.styles;

import com.lvg.fxtest.GenericJavaFXApplication;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SimpleCssSample extends GenericJavaFXApplication {
    private static final String CSS_PATH = "META-INF/css/buttons.css";

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        ((VBox)root).getChildren().addAll(new Button("Exit"));
        scene.getStylesheets().add(CSS_PATH);

    }
}
