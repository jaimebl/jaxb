package com.jaimebl.example;

import javax.xml.bind.annotation.*;
/**
 * Created by Jaime on 12/02/2015.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    public String getAddressType() {
        return _addressType;
    }

    public void setAddressType(String addressType) {
        this._addressType = addressType;
    }

    public String getStreet() {
        return _street;
    }

    public void setStreet(String street) {
        this._street = street;
    }

    @XmlAttribute
    private String _addressType;

    private String _street;

}
