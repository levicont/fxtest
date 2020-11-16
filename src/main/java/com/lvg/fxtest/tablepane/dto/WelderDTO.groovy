package com.lvg.fxtest.tablepane.dto

import com.lvg.fxtest.tablepane.models.Welder
import javafx.beans.property.LongProperty
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

import java.time.LocalDate

class WelderDTO extends GenericDTO{
    private final LongProperty idProperty = new SimpleLongProperty()
    private final StringProperty nameProperty = new SimpleStringProperty()
    private final StringProperty phoneProperty = new SimpleStringProperty()
    private final ObjectProperty<LocalDate> birthdayProperty = new SimpleObjectProperty<>()
    private final ObjectProperty<OrganizationDTO> organizationDTOProperty = new SimpleObjectProperty<>()
    private final ObjectProperty<Welder> welderProperty = new SimpleObjectProperty<>()

    WelderDTO(Welder welder){

        idProperty.set(welder.getId() == null ? NULL_ID : welder.getId())
        nameProperty.set(welder.getName() == null ? NULL_TEXT_FIELD : welder.getName())
        phoneProperty.set(welder.getPhone() == null ? NULL_TEXT_FIELD : welder.getPhone())
        birthdayProperty.set(welder.getBirthday() == null ? NULL_DATE_FIELD : welder.getBirthday())
        organizationDTOProperty.set(new OrganizationDTO(welder.getOrganization()))
        welderProperty.set(welder)
    }

    LongProperty idProperty(){return idProperty }

    StringProperty nameProperty(){return nameProperty }

    StringProperty phoneProperty(){return phoneProperty }

    ObjectProperty<LocalDate> birthdayProperty(){return birthdayProperty }

    ObjectProperty<Welder> welderProperty(){return welderProperty }

    ObjectProperty<OrganizationDTO> organizationDTOProperty(){return organizationDTOProperty }

    String toString(){
        return "WelderDTO: "+"id: "+idProperty().get()+"\n"+
                "name: "+nameProperty().get()+"\n"+
                "phone: "+phoneProperty().get()+"\n"+
                "birthday: "+birthdayProperty().get()+"\n"+
                "Organization: "+organizationDTOProperty().get()+"\n"
    }

    @Override
    int hashCode() {
        final int prime = 31
        int result = 1
        result = prime * result + ((idProperty == null) ? 0 : idProperty.hashCode())
        return result
    }

    @Override
    boolean equals(Object obj) {
        if (this == obj)
            return true
        if (obj == null)
            return false
        if (getClass() != obj.getClass())
            return false
        WelderDTO other = (WelderDTO) obj
        if (idProperty.get() != other.idProperty.get())
            return false
        return true
    }

}
