package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Teacher;
import com.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /*
    *
    * Get Teacher by ID
    *
    * */
    public Teacher findById(int id){
        return teacherService.findById(id);
    }

    /*
    *
    * Get Teacher List by First-Name
    *
    * */
    public List<Teacher> findByFirstNameContaining(String firstName){
        return teacherService.findByFirstNameContaining(firstName);
    }

    /*
    *
    * Get Teacher List by Middle-Name
    *
    * */
    public List<Teacher> findByMiddleNameContaining(String middleName){
        return teacherService.findByMiddleNameContaining(middleName);
    }

    /*
    *
    * Get Teacher by Last-Name
    *
    * */
    public List<Teacher> findByLastNameContaining(String lastName){
        return teacherService.findByLastNameContaining(lastName);
    }

    /*
    *
    * Get Teacher by Email ID
    *
    * */
    public List<Teacher> findByEmailContaining(String email){
        return teacherService.findByEmailContaining(email);
    }

    /*
    *
    * Get Teacher by Phone Number
    *
    * */
    public List<Teacher> findByPhoneNumberContaining(String phoneNumber){
        return teacherService.findByPhoneNumberContaining(phoneNumber);
    }

    /*
    *
    * Get Teacher by Gender
    *
    * */
    public List<Teacher> findByGenderContaining(String gender){
        return teacherService.findByGenderContaining(gender);
    }

    /*
    *
    * Get Teacher by First-Name, Middle-Name and Last-Name
    *
    * */
    public List<Teacher> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(String firstName, String middleName, String lastName, String email){
        return teacherService.findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(firstName, middleName, lastName, email);
    }

    /*
    *
    * Get Teacher List by Pagination
    *
    * */
    @GetMapping
    public List<Teacher> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "50", required = false) Integer pageSize
    ){
        return teacherService.findAll(PageRequest.of(pageNumber,pageSize));
    }

    /*
    *
    * Delete Teacher by ID
    *
    * */
    public Teacher deleteById(int id){
        return teacherService.deleteById(id);
    }
}
