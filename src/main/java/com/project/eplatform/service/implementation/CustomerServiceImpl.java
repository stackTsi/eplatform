package com.project.eplatform.service.implementation;

import com.project.eplatform.model.Customer;
import com.project.eplatform.repository.CustomerRepository;
import com.project.eplatform.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        log.info("Adding new Customer: {}", customer.getFullName());
        return customerRepository.save(customer);
    }

    @Override
    public Collection<Customer> list(int limit) {
        log.info("Fetching list of Customers");
        return customerRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Customer getCustomer(int customerID) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public Boolean deleteCustomer(int customerID) {
        return null;
    }
}
