package com.lvg.fxtest.colors;

import com.lvg.fxtest.GenericJavaFXApplication;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by Victor on 05.01.2017.
 */
public class GradientSample extends GenericJavaFXApplication{

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void init() throws Exception {
        super.init();

        root = new HBox();
        HBox localRoot = (HBox)root;

        VBox lgContainer = new VBox();
        VBox cgContainer = new VBox();

        initLinearGradients(lgContainer);
        initCircularGradients(cgContainer);
        localRoot.getChildren().addAll(lgContainer, cgContainer);


        scene.setRoot(localRoot);
    }

    private void initCircularGradients(VBox cgContainer) {
        Stop[] stops = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
        Paint rg1 = new RadialGradient(0,0, 0.5,0.5, 0.5, true, CycleMethod.NO_CYCLE, stops);
        Circle c1 = new Circle(50);
        c1.setFill(rg1);

        Paint rg2 = new RadialGradient(30,0.6, 0.5,0.5, 0.5, true, CycleMethod.NO_CYCLE, stops);
        Circle c2 = new Circle(50);
        c2.setFill(rg2);

        Paint rg3 = new RadialGradient(30,0.6, 0.5,0.5, 0.2, true, CycleMethod.NO_CYCLE, stops);
        Circle c3 = new Circle(50);
        c3.setFill(rg3);

        Paint rg4 = new RadialGradient(60,0.6, 0.5,0.5, 0.2, true, CycleMethod.REPEAT, stops);
        Circle c4 = new Circle(50);
        c4.setFill(rg4);

        cgContainer.getChildren().addAll(c1, c2, c3, c4);
    }

    private void initLinearGradients(VBox lgContainer){
        Rectangle r1 = new Rectangle(200, 100);
        Stop[] stops = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK) };
        Paint g1 = new LinearGradient(0,0,1,0, true, CycleMethod.NO_CYCLE, stops);
        r1.setFill(g1);

        Rectangle r2 = new Rectangle(200, 100);
        Paint g2 = new LinearGradient(0,0,0.1,0, true, CycleMethod.REFLECT, stops);
        r2.setFill(g2);

        Rectangle r3 = new Rectangle(200, 100);
        Paint g3 = new LinearGradient(0,0,0.1,0.1, true, CycleMethod.REPEAT, stops);
        r3.setFill(g3);

        Rectangle r4 = new Rectangle(200, 100);
        String gradientStr = "from 0% 0% to 25% 0%, repeat, red, yellow 40%,blue";
        Paint g4 = LinearGradient.valueOf(gradientStr);
        r4.setFill(g4);
        lgContainer.getChildren().addAll(r1,r2, r3, r4);
    }
}
