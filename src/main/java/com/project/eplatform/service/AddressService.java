package com.project.eplatform.service;

import com.project.eplatform.model.Address;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface AddressService {

    ResponseEntity<?> createAddress(Address address);
    Collection<Address> list(int limit);
    Address getAddress(int addressID);

    //update method is in CustomerServiceImpl.java : updateCustomer()

    Boolean deleteAddress(int addressID);
}
