package com.lvg.fxtest.tablepane.dto

import com.lvg.fxtest.tablepane.models.Organization
import javafx.beans.property.LongProperty
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

class OrganizationDTO extends GenericDTO{
    private final LongProperty idProperty = new SimpleLongProperty()
    private final StringProperty nameProperty = new SimpleStringProperty()
    private final StringProperty addressProperty = new SimpleStringProperty()
    private final ObjectProperty<Organization> organizationProperty = new SimpleObjectProperty<>()


    OrganizationDTO(Organization organization){

        idProperty.set(organization.getId())
        nameProperty.set(organization.getName())
        addressProperty.set(organization.getAddress())
        organizationProperty.set(organization)
    }

    LongProperty idProperty(){
        return idProperty
    }

    StringProperty nameProperty(){
        return nameProperty
    }

    StringProperty addressProperty(){
        return addressProperty
    }

    ObjectProperty<Organization> organizationProperty(){
        return organizationProperty
    }

    String toString(){
        return "Organization: id: "+idProperty.get() + "\t name: "+nameProperty.get() + "\t address: "+addressProperty.get()
    }

}
