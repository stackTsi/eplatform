package com.project.eplatform.service.implementation;

import com.project.eplatform.model.Address;
import com.project.eplatform.repository.AddressRepository;
import com.project.eplatform.service.AddressService;
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
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public Collection<Address> list(int limit) {
        log.info("Fetching list of Addresses");
        return addressRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Address getAddress(int addressID) {
        log.info("Getting address by ID");
        return addressRepository.findById(addressID).orElse(null);
    }


}
