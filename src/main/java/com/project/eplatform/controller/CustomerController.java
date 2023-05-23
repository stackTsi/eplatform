package com.project.eplatform.controller;


import com.project.eplatform.model.Customer;
import com.project.eplatform.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody Customer request){
        return customerService.createCustomer(request);
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<Customer>> listCustomer(@RequestParam(defaultValue = "10") int limit){
        Collection<Customer> customers = customerService.list(limit);
        return ResponseEntity.ok(customers);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int customerID){
        Customer customer = customerService.getCustomer(customerID);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int customerID,
                                                   @RequestBody Customer request){
        Customer updatedCustomer = customerService.updateCustomer(customerID,request);
        if(updatedCustomer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCustomer);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable("id")int customerID){
        Boolean customer = customerService.deleteCustomer(customerID);
        return ResponseEntity.ok(customer);
    }
}