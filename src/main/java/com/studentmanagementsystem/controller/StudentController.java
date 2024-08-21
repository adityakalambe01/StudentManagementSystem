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

    /*
    *
    * Get Student by ID
    *
    * */
    @GetMapping(value = "/{id}")
    public Student findById(@PathVariable("id") int id){
        return studentService.findById(id);
    }

    /*
    *
    * Get Student by Email Contating
    *
    * */
//    @GetMapping(value = "")
    public Student findByEmailContaining(String email){
        return studentService.findByEmailContaining(email);
    }

    /*
    *
    * Get Student by Email and School
    *
    * */
    public Student findByEmailContaining(String email, int schoolId){
        return studentService.findByEmailContaining(email, schoolId);
    }

    /*
    *
    * Get Student by Phone-Number
    *
    * */
    public List<Student> findByPhoneNumber(String mobile){
        return studentService.findByPhoneNumber(mobile);
    }

    /*
    *
    * Get Student by First Name
    *
    * */
    public List<Student> findByFirstNameContaining(String firstName){
        return studentService.findByFirstNameContaining(firstName);
    }

    /*
    *
    * Get Student by Middle Name
    *
    * */
    public List<Student> findByMiddleNameContaining(String middleName){
        return studentService.findByMiddleNameContaining(middleName);
    }

    /*
    *
    * Get Student by Last Name
    *
    * */
    public List<Student> findByLastNameContaining(String lastName){
        return studentService.findByLastNameContaining(lastName);
    }

    /*
    *
    * Get Student by First-Name, Middle-Name and Last-Name
    *
    * */
    public List<Student> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(String firstName, String middleName, String lastName, String email){
        return studentService.findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(firstName, middleName, lastName, email);
    }

    /*
    *
    * Get All Students by Pagination
    *
    * */
    public List<Student> findAll(Pageable pageable){
        return studentService.findAll(pageable);
    }

    /*
    *
    * Delete Student by ID
    *
    * */
    public Student deleteById(int id){
        return studentService.deleteById(id);
    }

    /*
    *
    * Update Student by ID
    *
    * */
    public Student updateStudent(Integer studentId, Student student){
        student.setId(studentId);
        return studentService.save(student);
    }

    /*
    *
    * Add New Student
    *
    * */
    public Student save(Student newStudent){
        return studentService.save(newStudent);
    }

}
