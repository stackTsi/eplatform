package com.project.eplatform.service;

import com.project.eplatform.model.Customer;

import java.util.Collection;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Collection<Customer> list(int limit);
    Customer getCustomer(int customerID);
    Customer updateCustomer(Customer customer);
    Boolean deleteCustomer(int customerID);
}
