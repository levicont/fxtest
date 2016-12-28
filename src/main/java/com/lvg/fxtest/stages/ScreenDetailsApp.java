package com.lvg.fxtest.stages;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class ScreenDetailsApp extends Application{
    private static final Logger LOGGER = Logger.getLogger(ScreenDetailsApp.class);


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<Screen> screens = Screen.getScreens();

        for (Screen screen : screens){
            print(screen);
        }

        Platform.exit();
    }

    private void print(Screen screen) {
        LOGGER.info("Screen details:");
        LOGGER.info("DPI: " + screen.getDpi());
        LOGGER.info("Screen bounds: ");
        Rectangle2D bounds = screen.getBounds();
        print(bounds);

        LOGGER.info("Visual bounds: ");
        Rectangle2D visualBounds = screen.getVisualBounds();
        print(visualBounds);
    }

    private void print(Rectangle2D bounds) {
        String format = String.format("minX=%.2f, minY=%.2f. width=%.2f, height=%.2f%n",bounds.getMinX(), bounds.getMinY(),
                bounds.getWidth(), bounds.getHeight());
        LOGGER.info(format);
    }


}
