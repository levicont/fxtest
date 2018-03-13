package com.lvg.fxtest.tablepane.models

import java.time.LocalDate

class Welder {
    private Long id
    private String name
    private String phone
    private LocalDate birthday
    private Organization organization


    Welder(String name, String phone, LocalDate birthday, Organization organzation) {
        this.id = IdGenerator.getId()
        this.name = name
        this.phone = phone
        this.birthday = birthday
        this.organization = organzation
    }

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getPhone() {
        return phone
    }

    void setPhone(String phone) {
        this.phone = phone
    }

    LocalDate getBirthday() {
        return birthday
    }

    void setBirthday(LocalDate birthday) {
        this.birthday = birthday
    }


    Organization getOrganization() {
        return organization
    }

    void setOrganization(Organization organization) {
        this.organization = organization
    }

    static Welder getWelder(){
        return new Welder("Иван", "123456", LocalDate.of(2000, 1, 1), Organization.getOrganization())
    }

}
