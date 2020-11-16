package com.lvg.fxtest.tablepane

import com.lvg.fxtest.tablepane.dto.WelderDTO
import com.lvg.fxtest.tablepane.dto.WelderTableViewDTO
import javafx.application.Platform
import javafx.beans.property.ReadOnlyBooleanWrapper
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.BorderPane

class TablePane extends BorderPane{

    private TableView<WelderTableViewDTO> table
    private WelderEditorPane fieldsPane = new WelderEditorPane(null)
    private Button btLoad = new Button("Load")

    TablePane(){
        super()
        init()

    }

    private void init(){

        table = new TableView<>()
        initColumns()

        table.setPlaceholder(new Label("Нет данных"))
        table.setTableMenuButtonVisible(true)
        WelderRepository.loadTableViewData()

        table.setItems(WelderRepository.welderTableViewDTOListProperty())



        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<WelderTableViewDTO>() {

            @Override
            void changed(ObservableValue<? extends WelderTableViewDTO> observable,
                         WelderTableViewDTO oldValue, WelderTableViewDTO selected) {
                if (selected != null){
                    WelderDTO welderDTO = WelderRepository.loadWelderDTO(selected.idProperty().get())

                    selected.nameProperty().bind(welderDTO.nameProperty())
                    selected.phoneProperty().bind(welderDTO.phoneProperty())

                    Platform.runLater({fieldsPane.setWelderDTO(welderDTO) })
                }
            }

        })

        btLoad.setOnAction( {action -> WelderRepository.loadAllData()})

        centerProperty().set(table)
        rightProperty().set(fieldsPane)
        bottomProperty().set(btLoad)
    }

    private void initColumns(){
        TableColumn<WelderTableViewDTO, String> name = new TableColumn<>("Name")
        TableColumn<WelderTableViewDTO, String> phone = new TableColumn<>("Phone")
        TableColumn<WelderTableViewDTO, Boolean> isISOWelder = new TableColumn<>("IS ISO WELDER")

        name.setCellValueFactory(new PropertyValueFactory<>("name"))
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"))


        isISOWelder.setCellValueFactory({cellData ->
            Boolean isOdd = cellData.getTableView().itemsProperty().get().indexOf(cellData.getValue()) % 2 == 0
            return new ReadOnlyBooleanWrapper(isOdd)
        })
        isISOWelder.setCellFactory(CheckBoxTableCell.<WelderTableViewDTO>forTableColumn(isISOWelder))


        table.getColumns().addAll(name, phone, isISOWelder)
    }

}
