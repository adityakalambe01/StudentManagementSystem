package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Address;
import com.studentmanagementsystem.entity.School;
import com.studentmanagementsystem.repo.SchoolRepository;
import com.studentmanagementsystem.service.AddressService;
import com.studentmanagementsystem.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private AddressService addressService;

    @Override
    public School findById(int id) {
        return schoolRepository.findById(id);
    }

    @Override
    public School save(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School updateSchoolAddress(int schoolId, int addressId) {
        Address address = addressService.findById(addressId);
        School school = schoolRepository.findById(schoolId);
        school.setAddress(address);
//        address.setSchool(school);

        return schoolRepository.save(school);
    }

    @Override
    public School deleteById(int id) {
        return schoolRepository.deleteById(id);
    }

    @Override
    public School findByName(String name) {
        return schoolRepository.findByName(name);
    }

    @Override
    public List<School> findByNameContaining(String name) {
        return schoolRepository.findByNameContaining(name);
    }

    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    @Override
    public List<School> findByPrincipleContaining(String principle) {
        return schoolRepository.findByPrincipleContaining(principle);
    }

    @Override
    public List<School> findByDetailsContaining(String details) {
        return schoolRepository.findByDetailsContaining(details);
    }
}
