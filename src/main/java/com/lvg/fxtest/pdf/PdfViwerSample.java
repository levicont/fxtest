package com.lvg.fxtest.pdf;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

/**
 * Created by Victor on 30.12.2016.
 */
public class PdfViwerSample extends Application {
    private static final Logger LOGGER = Logger.getLogger(PdfViwerSample.class);

    private WebView viewWEB;


    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        viewWEB = new WebView();
        String url = getClass().getResource("/META-INF/js/pdfjs/web/viewer.html").toExternalForm();
        viewWEB.getEngine().load(url);

        VBox root = new VBox();
        root.getChildren().addAll(viewWEB);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void init() throws Exception {

    }
}
