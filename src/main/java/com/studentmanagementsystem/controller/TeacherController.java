package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Teacher;
import com.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    public Teacher findById(int id){
        return teacherService.findById(id);
    }

    public List<Teacher> findByFirstNameContaining(String firstName){
        return teacherService.findByFirstNameContaining(firstName);
    }

    public List<Teacher> findByMiddleNameContaining(String middleName){
        return teacherService.findByMiddleNameContaining(middleName);
    }

    public List<Teacher> findByLastNameContaining(String lastName){
        return teacherService.findByLastNameContaining(lastName);
    }

    public List<Teacher> findByEmailContaining(String email){
        return teacherService.findByEmailContaining(email);
    }

    public List<Teacher> findByPhoneNumberContaining(String phoneNumber){
        return teacherService.findByPhoneNumberContaining(phoneNumber);
    }

    public List<Teacher> findByGenderContaining(String gender){
        return teacherService.findByGenderContaining(gender);
    }

    public List<Teacher> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(String firstName, String middleName, String lastName, String email){
        return teacherService.findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(firstName, middleName, lastName, email);
    }

    public Page<Teacher> findAll(Pageable pageable){
        return teacherService.findAll(pageable);
    }

    public Teacher deleteById(int id){
        return teacherService.deleteById(id);
    }
        
}
