package com.project.eplatform.service.implementation;

import com.project.eplatform.model.Address;
import com.project.eplatform.repository.AddressRepository;
import com.project.eplatform.service.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;


    @Override
    public ResponseEntity<?> createAddress(Address address) {
        log.info("Adding new address {}", address.getAddressID());
        Map<String, Object> response = new HashMap<>();
        addressRepository.save(address);
        response.put("response", address);
        return ResponseEntity.ok(response);
    }

    @Override
    public Collection<Address> list(int limit) {
        log.info("Fetching list of Addresses");
        return addressRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Address getAddress(int addressID) {
        log.info("Getting address by ID");
        return addressRepository.findById(addressID).get();
    }


    @Override
    public Boolean deleteAddress(int addressID) {
        log.info("Deleting Address by ID: {}",addressID);
        addressRepository.deleteById(addressID);
        return TRUE;
    }
}
