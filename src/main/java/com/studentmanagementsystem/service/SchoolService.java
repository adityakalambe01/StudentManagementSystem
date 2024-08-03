package com.studentmanagementsystem.service;

import com.studentmanagementsystem.entity.School;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SchoolService {
    School findById(int id);

    School save(School school);

    School updateSchoolAddress(@PathVariable("schoolId") int schoolId, @PathVariable("addressId") int addressId);

    School deleteById(int id);

    School findByName(String name);

    List<School> findByNameContaining(String name);

    List<School> findAll();

    List<School> findByPrincipleContaining(String principle);

    List<School> findByDetailsContaining(String details);

}
