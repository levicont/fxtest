package com.lvg.fxtest.tablepane

import com.lvg.fxtest.tablepane.dto.OrganizationDTO
import com.lvg.fxtest.tablepane.models.Organization
import javafx.util.StringConverter

class OrganizationConverter extends StringConverter<OrganizationDTO> {

    @Override
    OrganizationDTO fromString(String string) {

        Organization org = Organization.getOrganization()
        if (string == null){return new OrganizationDTO(org)
        }
        org.setName(string)
        return new OrganizationDTO(org)
    }

    @Override
    String toString(OrganizationDTO object) {
        if (object == null){
            return "none"
        }
        return object.nameProperty().get()
    }

}
