package com.project.eplatform.service;

import com.project.eplatform.model.Address;

import java.util.Collection;

public interface AddressService {

    Collection<Address> list(int limit);
    Address getAddress(int addressID);

    //update method is in CustomerServiceImpl.java : updateCustomer()

}
