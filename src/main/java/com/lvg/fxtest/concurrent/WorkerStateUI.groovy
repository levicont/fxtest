package com.lvg.fxtest.concurrent

import javafx.beans.binding.When
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.concurrent.Worker
import javafx.scene.control.Label
import javafx.scene.control.ProgressBar
import javafx.scene.control.TextArea
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox

class WorkerStateUI extends GridPane{

    private final Label title = new Label('')
    private final Label message = new Label('')
    private final Label running = new Label('')
    private final Label state = new Label('')
    private final Label totalWork = new Label('')
    private final Label workDone = new Label('')
    private final Label progress = new Label('')
    private final TextArea value = new TextArea('')
    private final TextArea exception = new TextArea('')
    private final ProgressBar progressBar = new ProgressBar()

    WorkerStateUI(){
        addUI()
    }


    WorkerStateUI(Worker<ObservableList<Long>> worker){
        addUI()
        bindToWorker(worker)
    }

    private void addUI() {
        value.prefColumnCount = 20
        value.prefRowCount = 3
        exception.prefColumnCount = 20
        exception.prefRowCount = 3
        this.hgap = 5.0d
        this.vgap = 5.0d
        addRow(0, new Label('Title:'), title)
        addRow(1, new Label('Message:'), message)
        addRow(2, new Label('Running:'), running)
        addRow(3, new Label('State:'), state)
        addRow(4, new Label('Total Work:'), totalWork)
        addRow(5, new Label('Work Done:'), workDone)
        addRow(6, new Label('Progress:'), new HBox(2,progressBar, progress))
        addRow(7, new Label('Value:'), value)
        addRow(8, new Label('Exception:'), exception)
    }

    void bindToWorker(final Worker<ObservableList<Long>> worker){
        title.textProperty().bind(worker.titleProperty())
        message.textProperty().bind(worker.messageProperty())
        running.textProperty().bind(worker.runningProperty().asString())
        state.textProperty().bind(worker.stateProperty().asString())
        totalWork.textProperty().bind(new When(worker.totalWorkProperty().isEqualTo(-1))
                                                .then('Unknown')
                                                .otherwise(worker.totalWorkProperty().asString()))
        workDone.textProperty().bind(new When(worker.workDoneProperty().isEqualTo(-1))
                .then('Unknown')
                .otherwise(worker.workDoneProperty().asString()))
        progress.textProperty().bind(new When(worker.progressProperty().isEqualTo(-1))
                .then('Unknown')
                .otherwise((worker.progressProperty() * 100.0).asString('%.2f%%')))
        progressBar.progressProperty().bind(worker.progressProperty())
        value.textProperty().bind(worker.valueProperty().asString())

        worker.exceptionProperty().addListener((ChangeListener){prop, oldValue, Throwable newValue ->
                if(newValue != null)
                    exception.setText(newValue.message)
                else exception.text = ''
        })

    }


}
