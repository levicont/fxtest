package com.lvg.fxtest.concurrent

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.stage.Stage

import static javafx.concurrent.Worker.State.READY
import static javafx.concurrent.Worker.State.RUNNING

class OneShotTask extends Application{
    Button startBtn = new Button('Start')
    Button cancelBtn = new Button('Cancel')
    Button exitBtn = new Button('Exit')


    PrimeFinderTask task = new PrimeFinderTask(1, 100)

    static void main(String[] args) {
        launch(OneShotTask.class, args)
    }

    @Override
    void start(Stage stage) throws Exception {
        startBtn.setOnAction({e -> startTask()})
        cancelBtn.setOnAction({e -> task.cancel()})
        exitBtn.setOnAction({e -> stage.close()})

        startBtn.disableProperty().bind(task.stateProperty().isNotEqualTo(READY))
        cancelBtn.disableProperty().bind(task.stateProperty().isNotEqualTo(RUNNING))
        GridPane pane = new WorkerStateUI(task)
        HBox buttonBox = new HBox(5, startBtn, cancelBtn, exitBtn)
        BorderPane root = new BorderPane()
        root.center = pane
        root.bottom = buttonBox
        root.style = '''-fx-padding: 10;
                        -fx-border-style: solid inside;
                        -fx-border-width: 2;
                        -fx-border-insets: 5;
                        -fx-border-color: blue; '''
        Scene scene = new Scene(root)
        stage.scene = scene
        stage.title = 'A Prime Number Finder Task'
        stage.show()
    }

    void startTask(){
        Thread backgroundThread = new Thread(task)
        backgroundThread.setDaemon(true)
        backgroundThread.start()
    }
}
