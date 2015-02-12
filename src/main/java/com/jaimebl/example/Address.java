package com.jaimebl.example;

import javax.xml.bind.annotation.*;
/**
 * Created by Jaime on 12/02/2015.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @XmlAttribute
    private String type;

    private String street;

}
