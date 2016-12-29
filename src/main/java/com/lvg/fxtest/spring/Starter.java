package com.lvg.fxtest.spring;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@EnableAutoConfiguration
@Component
@ComponentScan
public class Starter extends Application{
    private ConfigurableApplicationContext context;


    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void init() throws Exception {
       context = SpringApplication.run(Starter.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("JavaFX Application starting with Spring Boot");
        VBox root = new VBox();
        root.getChildren().addAll(label);

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        context.stop();
    }
}
