package com.lvg.fxtest.tablepane

import javafx.application.Application
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class FXApplication extends Application{

    static void main(String[] args) {
        launch(FXApplication.class, args)
    }


    @Override
    void start(Stage primaryStage) throws Exception {
        Parent parent = new TablePane()
        Scene scene = new Scene(parent, 500, 400)
        primaryStage.setScene(scene)
        primaryStage.setTitle("TableView Test")
        primaryStage.show()
    }
}
