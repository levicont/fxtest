package com.lvg.fxtest.tablepane

import com.lvg.fxtest.tablepane.dto.OrganizationDTO
import com.lvg.fxtest.tablepane.dto.WelderDTO
import com.lvg.fxtest.tablepane.dto.WelderTableViewDTO
import com.lvg.fxtest.tablepane.models.Organization
import com.lvg.fxtest.tablepane.models.Welder
import javafx.beans.property.ListProperty
import javafx.beans.property.SimpleListProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.collections.transformation.FilteredList

class WelderRepository {
    final static ObservableList<WelderDTO> WELDER_DTO_LIST = FXCollections.observableArrayList()
    final static ObservableList<OrganizationDTO> ORGANIZATION_DTO_LIST = FXCollections.observableArrayList()

    static {
        WELDER_DTO_LIST.add(new WelderDTO(Welder.getWelder()))
        WELDER_DTO_LIST.add(new WelderDTO(Welder.getWelder()))
        WELDER_DTO_LIST.add(new WelderDTO(Welder.getWelder()))

        ORGANIZATION_DTO_LIST.add(new OrganizationDTO(new Organization('Microsoft','NYC USA')))
        ORGANIZATION_DTO_LIST.add(new OrganizationDTO(new Organization('IBM','Chicago USA')))
        ORGANIZATION_DTO_LIST.add(new OrganizationDTO(new Organization('BBC','London UK')))
    }

    private static final ListProperty<WelderTableViewDTO> welderTableViewDTOListProperty =
            new SimpleListProperty<>(FXCollections.observableArrayList())

    private static final FilteredList<OrganizationDTO> organizationDTOListProperty =
            new FilteredList<OrganizationDTO>(ORGANIZATION_DTO_LIST,{true})

    static ListProperty<WelderTableViewDTO> welderTableViewDTOListProperty(){
        return welderTableViewDTOListProperty
    }

    static FilteredList<OrganizationDTO> organizationDTOListProperty(){
        return organizationDTOListProperty
    }

    private static void loadTableViewData(){
        welderTableViewDTOListProperty.clear()
        WELDER_DTO_LIST.stream().forEach(   {welderDTO ->
            welderTableViewDTOListProperty.add(new WelderTableViewDTO(welderDTO.welderProperty().get()))
        })
    }

    private static void loadOrganizationData(){
//        organizationDTOListProperty.clear()
//        ORGANIZATION_DTO_LIST.stream().forEach({organizationDTO ->
//            organizationDTOListProperty.add(organizationDTO)
//        })
    }

    static void loadAllData(){
        loadTableViewData()
        loadOrganizationData()
    }

    static WelderDTO loadWelderDTO(Long id){
        WelderDTO result
        result = WELDER_DTO_LIST.stream().filter( {welderDTO -> return welderDTO.idProperty().get() == id }).findFirst().get()
        if(result == null)
            throw new NullPointerException("Cannot find welder with id: "+id)
        System.out.println("--- WelderRepository.loadWelderDTO(Long id): WelderDTO has found with id: "+id+". It has name: "+result.nameProperty().get())
        return result
    }
}
