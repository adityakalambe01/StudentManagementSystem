package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.entity.Subject;
import com.studentmanagementsystem.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    /*
    *
    * Get Subject by ID
    *
    * */
    Subject findById(int id){
        return subjectService.findById(id);
    }
        
    /*
    *
    * Get Subject by Name
    *
    * */
    List<Subject> findByNameContaining(String name){
        return subjectService.findByNameContaining(name);
    }

    /*
    *
    * Get All Subject's
    *
    * */
    List<Subject> findAll(Pageable pageable){
        return subjectService.findAll(pageable);
    }

    /*
    *
    * Get All Student's by Name
    *
    * */
    Page<Student> findAllByName(Pageable pageable, String name){
        return subjectService.findAllByName(pageable,name);
    }
        
}
