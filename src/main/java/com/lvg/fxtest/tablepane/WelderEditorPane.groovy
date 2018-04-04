package com.lvg.fxtest.tablepane

import com.lvg.fxtest.tablepane.dto.OrganizationDTO
import com.lvg.fxtest.tablepane.dto.WelderDTO
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.collections.transformation.FilteredList
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import javafx.util.StringConverter
import org.apache.log4j.Logger

import java.util.function.Predicate

class WelderEditorPane extends GridPane{
    private static final Logger LOGGER = Logger.getLogger(WelderEditorPane.class)
    private static int listenersCounter = 0

    private Label lbName = new Label("Name")
    private Label lbPhone = new Label("Phone")
    private Label lbBirthday = new Label("Birthday")
    private Label lbOrganization = new Label("Organization")
    private Label lbTitle = new Label("Title")
    private TextField txfName = new TextField()
    private TextField txfPhone = new TextField()
    private DatePicker dpBirthday = new DatePicker()
    private ComboBox<OrganizationDTO> cbOrganization = new ComboBox<>()
    private ComboBox<Title> cbTitles = new ComboBox<>()

    private WelderDTO welderDTO
    private final ObjectProperty<WelderDTO> welderDTOProperty = new SimpleObjectProperty<>(welderDTO)


    WelderEditorPane(WelderDTO welderDTO){
        super()
        if (null != welderDTO){
            this.welderDTO = welderDTO
            bind()
        }
        init()


    }

    private void init(){

        add(lbName,0,0)
        add(txfName,1,0)

        add(lbPhone,0,1)
        add(txfPhone,1,1)

        add(lbBirthday,0,2)
        add(dpBirthday,1,2)

        add(lbOrganization,0,3)
        add(cbOrganization,1,3)
        initCBOrganization()

        add(lbTitle, 0, 4)
        add(cbTitles, 1, 4)
        initCBTitle()


    }

    private void initCBTitle(){
        cbTitles.setConverter(new TitleConverter())
        cbTitles.setEditable(true)
        cbTitles.valueProperty().addListener(new ChangeListener<Title>() {
            @Override
            void changed(ObservableValue<? extends Title> observable, Title oldValue, Title newValue) {
                LOGGER.debug("cbTitle ChangeValueListener: value changed ")
                LOGGER.debug("cbTitle ChangeValueListener: new value is:" + newValue)
            }
        })
    }

    private void initCBOrganization(){
        cbOrganization.setConverter(new OrganizationConverter())
        cbOrganization.setEditable(true)
        cbOrganization.setItems(WelderRepository.organizationDTOListProperty())
        cbOrganization.valueProperty().addListener(new ChangeListener<OrganizationDTO>() {
            private final int COUNTER = listenersCounter+1
            private int calledCounter = 0
            @Override
            void changed(ObservableValue<? extends OrganizationDTO> observable,
                         OrganizationDTO oldValue, OrganizationDTO newValue) {
                LOGGER.debug("cbOrganization ChangeValueListener: value changed, calling: ${++calledCounter} times")
                LOGGER.debug("cbOrganization ChangeValueListener: COUNTER:  "+ COUNTER)
                //	LOGGER.debug("cbOrganization ChangeValueListener: listener: " + this.getClass().getName());
                //	LOGGER.debug("cbOrganization ChangeValueListener: new value is:" + newValue);
                //	LOGGER.debug("cbOrganization ChangeValueListener: observable value is:" + observable);
                LOGGER.debug("cbOrganization ChangeValueListener: items is:" + cbOrganization.getItems())


            }

        })
        cbOrganization.editorProperty().get().textProperty().addListener(new ChangeListener<String>() {
            @Override
            void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!cbOrganization.editorProperty().get().isFocused())
                    return
                FilteredList<OrganizationDTO> list = (FilteredList<OrganizationDTO>)cbOrganization.getItems()
                if (newValue == null || newValue.isEmpty()){
                   list.setPredicate({true})
                }else{
                    list.setPredicate({ org ->
                        return org.nameProperty().get().toLowerCase().contains(newValue.toLowerCase())
                    })


                }

                cbOrganization.visibleRowCountProperty().set(10)
                cbOrganization.show()

            }
        })


    }

    private void bind(){
        LOGGER.debug("WelderEditorPane.bind(): STARTING")
        WelderDTO welderDTO = welderDTOProperty.get()
        LOGGER.debug("WelderEditorPane.bind(): WelderDTO is "+ welderDTO)
        txfName.textProperty().bindBidirectional(welderDTO.nameProperty())
        txfPhone.textProperty().bindBidirectional(welderDTO.phoneProperty())
        dpBirthday.valueProperty().bindBidirectional(welderDTO.birthdayProperty())
        cbOrganization.valueProperty().bindBidirectional(welderDTO.organizationDTOProperty())
        LOGGER.debug("WelderEditorPane.bind(): END")
    }

    private void unbind(WelderDTO welderDTO){
        welderDTO.birthdayProperty().unbindBidirectional(dpBirthday.valueProperty())
        welderDTO.nameProperty().unbindBidirectional(txfName.textProperty())
        welderDTO.phoneProperty().unbindBidirectional(txfPhone.textProperty())
        welderDTO.organizationDTOProperty().unbindBidirectional(cbOrganization.valueProperty())
    }

    void setWelderDTO(WelderDTO welderDTO){
        if (null != this.welderDTO) unbind(this.welderDTO)
        this.welderDTOProperty.set(welderDTO)
        this.welderDTO = welderDTO
        bind()
    }

    WelderDTO getWelderDTO(){
        return this.welderDTO
    }

    private class Title{

        private final StringProperty titleProperty = new SimpleStringProperty('none')

        StringProperty titleProperty(){
            titleProperty
        }

        String toString(){
            return titleProperty.get()
        }
    }

    private class TitleConverter extends StringConverter<Title>{
        @Override
        String toString(Title object) {
            if (object == null) return 'null'
            return object.titleProperty().get()
        }

        @Override
        Title fromString(String string) {
            Title title = new Title()
            return title.titleProperty().set(string)
        }
    }


}
