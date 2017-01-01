package com.lvg.fxtest.bounds;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by Victor Levchenko LVG Corp. on 30.12.16.
 */
public class LayoutBoundsSample extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();

        Rectangle rect = new Rectangle(0, 0, 70, 50);

        initRectangle(rect);

        root.getChildren().addAll(rect);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void initRectangle(Rectangle rectangle){
        rectangle.setFill(Paint.valueOf("red"));
        rectangle.setCursor(Cursor.HAND);
        rectangle.setEffect(new DropShadow());
    }


}
