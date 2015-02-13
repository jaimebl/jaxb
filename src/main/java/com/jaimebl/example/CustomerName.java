package com.jaimebl.example;

import javax.xml.bind.annotation.*;

/**
 * Created by Jaime on 12/02/2015.
 */
@XmlRootElement
@XmlType(propOrder={"_fullName", "_shippingAddress"})
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerName {

    @XmlAttribute
    private long _id;

    private String _fullName;

    private Address _shippingAddress;

    public Address getShippingAddress() {
        return _shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this._shippingAddress = shippingAddress;
    }

    public String getFullName() {
        return _fullName;
    }

    public void setFullName(String fullName) {
        this._fullName = fullName;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }


}
