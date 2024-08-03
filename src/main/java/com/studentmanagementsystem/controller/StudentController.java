package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/{id}")
    public Student findById(@PathVariable("id") int id){
        return studentService.findById(id);
    }

//    @GetMapping(value = "")
    public Student findByEmailContaining(String email){
        return studentService.findByEmailContaining(email);
    }

    public Student findByEmailContaining(String email, int schoolId){
        return studentService.findByEmailContaining(email, schoolId);
    }

    public List<Student> findByPhoneNumber(String mobile){
        return studentService.findByPhoneNumber(mobile);
    }

    public List<Student> findByFirstNameContaining(String firstName){
        return studentService.findByFirstNameContaining(firstName);
    }

    public List<Student> findByMiddleNameContaining(String middleName){
        return studentService.findByMiddleNameContaining(middleName);
    }

    public List<Student> findByLastNameContaining(String lastName){
        return studentService.findByLastNameContaining(lastName);
    }

    public List<Student> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(String firstName, String middleName, String lastName, String email){
        return studentService.findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(firstName, middleName, lastName, email);
    }

    public Page<Student> findAll(Pageable pageable){
        return studentService.findAll(pageable);
    }

    public Student deleteById(int id){
        return studentService.deleteById(id);
    }

}
