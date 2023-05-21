package com.project.eplatform.repository;


import com.project.eplatform.model.Address;
import com.project.eplatform.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByEmail (String email);
    List<Customer> findByAddress (Address address);
    Customer findByUserName(String username);
}
