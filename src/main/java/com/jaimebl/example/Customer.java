package com.jaimebl.example;

import javax.xml.bind.annotation.*;

/**
 * Created by Jaime on 12/02/2015.
 */
@XmlRootElement
@XmlType(propOrder={"fullName", "shippingAddress"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    @XmlAttribute
    private long id;

    private String fullName;


    private Address shippingAddress;

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
