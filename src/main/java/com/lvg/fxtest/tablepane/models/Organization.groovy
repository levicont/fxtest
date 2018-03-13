package com.lvg.fxtest.tablepane.models

class Organization {

    private Long id
    private String name
    private String address

    Organization(String name, String address){
        this.id = IdGenerator.getId()
        this.name = name
        this.address = address
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


    String getAddress() {
        return address
    }


    void setAddress(String address) {
        this.address = address
    }


    String toString(){
        return "name: " + name +"\n" + "address: " + address +"\n"
    }

    static Organization getOrganization(){
        return new Organization("IBM", "NYC USA")
    }

}
