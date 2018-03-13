package com.lvg.fxtest.tablepane.dto

import com.lvg.fxtest.tablepane.models.Welder
import javafx.beans.property.LongProperty
import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

class WelderTableViewDTO extends GenericDTO{
    private final LongProperty idProperty = new SimpleLongProperty(NULL_ID)
    private final StringProperty nameProperty = new SimpleStringProperty()
    private final StringProperty phoneProperty = new SimpleStringProperty()

    WelderTableViewDTO(Welder welder){
        this.idProperty.set(welder.getId() == null ? NULL_ID : welder.getId())
        this.nameProperty.set(welder.getName() == null ? NULL_TEXT_FIELD : welder.getName())
        this.phoneProperty.set(welder.getPhone() == null ? NULL_TEXT_FIELD : welder.getPhone())
    }

    LongProperty idProperty(){
        return idProperty
    }

    StringProperty nameProperty(){
        return nameProperty
    }

    StringProperty phoneProperty(){
        return phoneProperty
    }

    String toString(){
        return "WelderTableViewDTO: "+"id: "+idProperty().get()+"\n"+
                "name: "+nameProperty().get()+"\n"+
                "phone: "+phoneProperty().get()+"\n"

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
        WelderTableViewDTO other = (WelderTableViewDTO) obj
        if (idProperty == null) {
            if (other.idProperty != null)
                return false
        } else if (!idProperty.equals(other.idProperty))
            return false
        return true
    }

}
