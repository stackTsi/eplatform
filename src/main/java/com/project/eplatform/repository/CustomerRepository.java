package com.project.eplatform.repository;


import com.project.eplatform.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByEmail (String email);
}
