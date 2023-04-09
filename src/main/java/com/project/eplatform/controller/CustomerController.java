package com.project.eplatform.controller;


import com.project.eplatform.model.Customer;
import com.project.eplatform.service.implementation.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServiceImpl customerService;

    @GetMapping("/list")
    public ResponseEntity<Collection<Customer>> listCustomer(@RequestParam(defaultValue = "10") int limit){
        Collection<Customer> customers = customerService.list(limit);
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer request){
        return customerService.createCustomer(request);
    }

}
