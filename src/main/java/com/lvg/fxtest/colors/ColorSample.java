package com.lvg.fxtest.colors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.net.URL;

/**
 * Created by Victor Levchenko LVG Corp. on 04.01.17.
 */
public class ColorSample extends Application{

    private static final Logger LOGGER = Logger.getLogger(ColorSample.class);
    private static final String IMAGE_PATH = "META-INF/img/ok_pic.png";
    private Image image;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ImagePattern imagePattern = new ImagePattern(image,0,0,0.25,0.25,true);
        HBox root = new HBox();

        Rectangle r1 = new Rectangle(300, 200);
        r1.setFill(imagePattern);

        imagePattern = new ImagePattern(image, 60, 40, 0.5, 0.5, true);
        Rectangle r2 = new Rectangle(300, 200, imagePattern);

        imagePattern = new ImagePattern(image, 0, 0, 0.1, 0.1, true);
        Circle c2 = new Circle(50, 50, 60, imagePattern);

        root.getChildren().addAll(r1,r2,c2);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void init() throws Exception {
        URL imgUrl = getClass().getClassLoader().getResource(IMAGE_PATH);
        if(imgUrl == null){
            LOGGER.warn(IMAGE_PATH + ": image file not found");
            Platform.exit();
            return;
        }
        image = new Image(imgUrl.toExternalForm());

    }
}
