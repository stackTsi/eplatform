package com.project.eplatform.service.implementation;


import com.project.eplatform.model.Address;
import com.project.eplatform.model.Customer;
import com.project.eplatform.repository.CustomerRepository;
import com.project.eplatform.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> createCustomer(Customer customer) {
        Map<String, Object> response = new HashMap<>();
        log.info("Adding new Customer: {}", customer.getFullName());
        if(customer.getEmail() != null){
            Customer repository = customerRepository.findByEmail(customer.getEmail());
            if(repository != null){
                response.put("Error","Email have exist");
                return ResponseEntity.of(Optional.of(response));
            }
        }
        String encodedPass = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPass);
        customerRepository.save(customer);
        response.put("response",customer);
        return ResponseEntity.ok(response);
    }

    @Override
    public Collection<Customer> list(int limit) {
        log.info("Fetching list of Customers");
        return customerRepository.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Customer getCustomer(int customerID) {
        log.info("Fetching customer info by ID");
        return customerRepository.findById(customerID).orElse(null);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        log.info("Updating customer {}",customer.getCustomerID());
        Customer existingCustomer = customerRepository.findById(customer.getCustomerID()).orElse(null);
       if(existingCustomer == null){
           return null;
        }
        if(customer.getFullName() != null){
            existingCustomer.setFullName(customer.getFullName());
        }
        if(customer.getEmail() != null){
            existingCustomer.setEmail(customer.getEmail());
        }
        if(customer.getUserName() != null){
            existingCustomer.setUserName(customer.getUserName());
        }
        //if the customer object does have an address object associated, but the customer entity does not
        if(customer.getAddress() != null){
            Address existingAddress = existingCustomer.getAddress();
            if(existingAddress == null){
                existingAddress = new Address();
                existingCustomer.setAddress(existingAddress);
            }
            if(customer.getAddress().getStreetNum() != null){
                existingAddress.setStreetNum(customer.getAddress().getStreetNum());
            }
            if(customer.getAddress().getStreetName() != null){
                existingAddress.setStreetName(customer.getAddress().getStreetName());
            }
            if(customer.getAddress().getWard() != null){
                existingAddress.setWard(customer.getAddress().getWard());
            }
            if(customer.getAddress().getDistrict() != null){
                existingAddress.setDistrict(customer.getAddress().getDistrict());
            }
            if(customer.getAddress().getCity() != null){
                existingAddress.setCity(customer.getAddress().getCity());
            }
            if(customer.getAddress().getPostalCode() != null){
                existingAddress.setPostalCode(customer.getAddress().getPostalCode());
            }
        }
        return customerRepository.save(existingCustomer);
    }

    @Override
    public Boolean deleteCustomer(int customerID) {
        log.info("Deleting Customer by ID: {}",customerID);
        customerRepository.deleteById(customerID);
        return TRUE;
    }
}
