package com.lvg.fxtest.tablepane

import com.lvg.fxtest.tablepane.dto.OrganizationDTO
import com.lvg.fxtest.tablepane.dto.WelderDTO
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import org.apache.log4j.Logger

class WelderEditorPane extends GridPane{
    private static final Logger LOGGER = Logger.getLogger(WelderEditorPane.class)
    private static int listenersCounter = 0

    private Label lbName = new Label("Name")
    private Label lbPhone = new Label("Phone")
    private Label lbBirthday = new Label("Birthday")
    private Label lbOrganization = new Label("Organization")
    private TextField txfName = new TextField()
    private TextField txfPhone = new TextField()
    private DatePicker dpBirthday = new DatePicker()
    private ComboBox<OrganizationDTO> cbOrganization = new ComboBox<>()

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
        cbOrganization.setConverter(new OrganizationConverter())
        cbOrganization.setEditable(true)
        cbOrganization.valueProperty().addListener(new ChangeListener<OrganizationDTO>() {
            private final int COUNTER = listenersCounter+1

            @Override
            void changed(ObservableValue<? extends OrganizationDTO> observable,
                         OrganizationDTO oldValue, OrganizationDTO newValue) {
                LOGGER.debug("cbOrganization ChangeValueListener: value changed ")
                LOGGER.debug("cbOrganization ChangeValueListener: COUNTER:  "+ COUNTER)
                //	LOGGER.debug("cbOrganization ChangeValueListener: listener: " + this.getClass().getName());
                //	LOGGER.debug("cbOrganization ChangeValueListener: new value is:" + newValue);
                //	LOGGER.debug("cbOrganization ChangeValueListener: observable value is:" + observable);
                LOGGER.debug("cbOrganization ChangeValueListener: items is:" + cbOrganization.getItems())


            }

        })

        /*cbOrganization.addEventHandler(Event.ANY, new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                if (event.getEventType() == ActionEvent.ACTION ){
                    LOGGER.debug("cbOrganization ActionEvent: event occurs ACTION type: "+event.getEventType());
                    event.consume();
                    cbOrganization.valueProperty().set(null);
                }
                LOGGER.debug("cbOrganization ActionEvent: event occurs type: "+event.getEventType());

            }

        });
        */
        /*cbOrganization.valueProperty().addListener(new InvalidationListener() {

            @Override
            public void invalidated(Observable observable) {
                LOGGER.debug("cbOrganization IvalidatedValueListener: value changed ");
                LOGGER.debug("cbOrganization IvalidatedValueListener: new value is:" +
                                ((ObjectProperty<OrganizationDTO>)observable).get());
                LOGGER.debug("cbOrganization IvalidatedValueListener: items is:" + cbOrganization.getItems());

            }
        });*/

        /*cbOrganization.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<OrganizationDTO>() {

            @Override
            public void changed(ObservableValue<? extends OrganizationDTO> observable,
                    OrganizationDTO oldValue, OrganizationDTO newValue) {
                LOGGER.debug("cbOrganization ChangeSelectedItemListener: value changed ");
                LOGGER.debug("cbOrganization ChangeSelectedItemListener: new value is:" + newValue);
                LOGGER.debug("cbOrganization ChangeSelectedItemListener: items is:" + cbOrganization.getItems());

            }

        });*/
    }

    private void bind(){
        LOGGER.debug("WelderEditorPane.bind(): STARTING")
        WelderDTO welderDTO = welderDTOProperty.get()
        LOGGER.debug("WelderEditorPane.bind(): WelderDTO is "+ welderDTO)
        txfName.textProperty().bindBidirectional(welderDTO.nameProperty())
        txfPhone.textProperty().bindBidirectional(welderDTO.phoneProperty())
        dpBirthday.valueProperty().bindBidirectional(welderDTO.birthdayProperty())
        //cbOrganization.valueProperty().bindBidirectional(welderDTO.organizationDTOProperty());
        LOGGER.debug("WelderEditorPane.bind(): END")
    }

    private void unbind(WelderDTO welderDTO){
        welderDTO.birthdayProperty().unbindBidirectional(dpBirthday.valueProperty())
        welderDTO.nameProperty().unbindBidirectional(txfName.textProperty())
        welderDTO.phoneProperty().unbindBidirectional(txfPhone.textProperty())
        //welderDTO.organizationDTOProperty().unbindBidirectional(cbOrganization.valueProperty());
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


}
