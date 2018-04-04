package com.lvg.fxtest.tablepane

import com.lvg.fxtest.tablepane.dto.OrganizationDTO
import com.lvg.fxtest.tablepane.models.Organization
import javafx.util.StringConverter
import org.apache.log4j.Logger

class OrganizationConverter extends StringConverter<OrganizationDTO> {
    private static final Logger LOGGER = Logger.getLogger(OrganizationConverter.class)


    @Override
    OrganizationDTO fromString(String string) {
        LOGGER.debug("OrganizationConverter fromString() called: string: ${string}")
        if (string == null){return getDefaultOrganizationDTO()
        }


        OrganizationDTO result = null

        WelderRepository.organizationDTOListProperty().stream().forEach({organizationDTO ->
            if (string.toLowerCase() == organizationDTO.nameProperty().get().toLowerCase()) {
                result = organizationDTO
                LOGGER.debug("OrganizationConverter fromString() called: string has found in repository, result is: ${result}")
            }

        })

        if (null == result) {
            result = getDefaultOrganizationDTO()
            result.nameProperty().set(string)
        }


        LOGGER.debug("OrganizationConverter fromString() called: result: ${result}")
        return result
    }

    @Override
    String toString(OrganizationDTO object) {
        if (object == null){
            return "none"
        }
        return object.nameProperty().get()
    }

    private static OrganizationDTO getDefaultOrganizationDTO(){
        OrganizationDTO result = new OrganizationDTO(Organization.getOrganization())
        result.idProperty().set(0)
        return result
    }

}
