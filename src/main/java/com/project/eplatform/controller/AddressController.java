package com.project.eplatform.controller;

import com.project.eplatform.model.Address;
import com.project.eplatform.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;


    @GetMapping("/list")
    public ResponseEntity<Collection<Address>> listAddress(@RequestParam(defaultValue = "10") int limit) {
        Collection<Address> addresses = addressService.list(limit);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable("id") int addressID){
        Address address = addressService.getAddress(addressID);
        return ResponseEntity.ok(address);
    }


}
