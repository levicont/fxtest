package com.lvg.fxtest.concurrent

import javafx.application.Application
import javafx.application.Platform
import javafx.beans.binding.Bindings
import javafx.collections.ObservableList
import javafx.concurrent.ScheduledService
import javafx.concurrent.Task
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.stage.Stage
import javafx.util.Duration

import static javafx.concurrent.Worker.State.RUNNING
import static javafx.concurrent.Worker.State.SCHEDULED

class PrimeFinderScheduledService extends Application{
    Button startBtn = new Button('Start')
    Button cancelBtn = new Button('Cancel')
    Button resetBtn = new Button('Reset')
    Button exitBtn = new Button('Exit')
    boolean onceStarted = false

    ScheduledService<ObservableList<Long>> service = new ScheduledService<ObservableList<Long>>() {
        @Override
        protected Task<ObservableList<Long>> createTask() {
            return new PrimeFinderTask()
        }
    }

    static void main(String[] args) {
        launch(PrimeFinderScheduledService.class, args)
    }

    @Override
    void start(Stage stage) throws Exception {
        service.setDelay(Duration.seconds(5))
        service.setPeriod(Duration.seconds(30))
        service.setMaximumFailureCount(5)

        addEventHandlers()
        bindButtonState()

        GridPane pane = new WorkerStateUI(service)
        HBox buttonBox = new HBox(5, startBtn, cancelBtn, resetBtn, exitBtn)
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
        stage.title = 'A Prime Number Finder Scheduled Service'
        stage.show()
    }

    void addEventHandlers(){
        startBtn.setOnAction({e ->
            if(onceStarted)
                service.restart()
            else {
                service.start()
                onceStarted = true
                startBtn.setText('Restart')
            }
        })

        cancelBtn.setOnAction({e -> service.cancel()})
        exitBtn.setOnAction({e -> Platform.exit()})
        resetBtn.setOnAction({e -> service.reset()})
    }

    void bindButtonState(){
        cancelBtn.disableProperty().bind(service.stateProperty().isNotEqualTo(RUNNING))
        resetBtn.disableProperty().bind(Bindings.or(service.stateProperty().isEqualTo(RUNNING),
                service.stateProperty().isEqualTo(SCHEDULED)))
    }
}
