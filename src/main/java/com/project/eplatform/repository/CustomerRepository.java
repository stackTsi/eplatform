package com.project.eplatform.repository;


import com.project.eplatform.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
