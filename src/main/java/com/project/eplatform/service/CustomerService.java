package com.project.eplatform.service;


import com.project.eplatform.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface CustomerService {
    ResponseEntity<?> createCustomer(Customer customer);
    Collection<Customer> list(int limit);
    Customer getCustomer(int customerID);
    Customer updateCustomer(Customer customer);
    Boolean deleteCustomer(int customerID);
}
