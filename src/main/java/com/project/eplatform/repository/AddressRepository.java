package com.project.eplatform.repository;

import com.project.eplatform.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    List<Address> findByStreetNumAndStreetNameAndWardAndDistrictAndCity(String streetNum, String streetName, String ward, String district, String city);
}
