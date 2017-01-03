package com.lvg.fxtest.bounds;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

/**
 * Created by Victor Levchenko LVG Corp. on 30.12.16.
 */
public class LayoutBoundsSample extends Application {
    private static final Logger LOGGER = Logger.getLogger(LayoutBoundsSample.class);

    private Button btMove;
    private Button btBias;
    private Button btEnableBias;
    private Rectangle rect;

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();

        rect = new Rectangle(0, 0, 70, 50);

        initRectangle(rect);

        root.getChildren().addAll(rect, btMove, btBias, btEnableBias);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void initRectangle(Rectangle rectangle){
        rectangle.setFill(Paint.valueOf("red"));
        rectangle.setCursor(Cursor.HAND);
        rectangle.setEffect(new DropShadow());
    }

    @Override
    public void init() throws Exception {
        rect = new Rectangle(0, 0, 70, 50);

        initRectangle(rect);

        btMove = new Button("Move");
        btMove.setOnAction(e -> rect.getTransforms().addAll(new Translate(100, 80), new Rotate(30), new Scale(1.2,1.2),
                new Shear(1.2,1.2)));

        btBias = new Button("JavaFX New Application");
        btEnableBias = new Button("Enable");
        btEnableBias.setOnAction(e -> {
            if (btBias.getContentBias()!= null){
                btBias.setWrapText(false);
                btBias.setPrefWidth(-1);
                LOGGER.info("Content bias of BiasButton: "+btBias.getContentBias());

            }
            else {
                btBias.setWrapText(true);
                btBias.setPrefWidth(40);
                LOGGER.info("Content bias of BiasButton: "+btBias.getContentBias());
            }
                }
        );


    }
}
