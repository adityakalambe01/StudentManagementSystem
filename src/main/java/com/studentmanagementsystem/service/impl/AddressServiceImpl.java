package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Address;
import com.studentmanagementsystem.repo.AddressRepository;
import com.studentmanagementsystem.service.AddressService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;


    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAll(Pageable pageable) {
        return addressRepository.findAll(pageable).getContent();
    }

    @Override
    public Address findById(int id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findByDistrictContaining(String district) {
        return addressRepository.findByDistrictContaining(district);
    }

    @Override
    public List<Address> findByCityContaining(String city) {
        return addressRepository.findByCityContaining(city);
    }

    @Override
    public List<Address> findByStateContaining(String state) {
        return addressRepository.findByStateContaining(state);
    }

    @Override
    public List<Address> findByAreaContaining(String area) {
        return addressRepository.findByAreaContaining(area);
//        return addressRepository.findByAreaContaining(area);
    }

    @Override
    public List<Address> findByZip(Integer zipcode) {
        return addressRepository.findByZip(zipcode);
    }

    @Override
    public Address deleteById(int id) {
        return addressRepository.deleteById(id);
    }

    @Override
    public Address updateAddress(int id, Address updatedAddress) {
        updatedAddress.setId(id);
        return findById(id)==null? null : addressRepository.save(updatedAddress);
    }

    @PostConstruct
    public void init() {
        if (addressRepository.count() == 0) {
            for (int i = 1; i <= 100; i++) {
                Address address = new Address();
                address.setZip(new RandomNameGenerator().nextInt(9, 6));
                addressRepository.save(address);
            }
        }
    }
}
