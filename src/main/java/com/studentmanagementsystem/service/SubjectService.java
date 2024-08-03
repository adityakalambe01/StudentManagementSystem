package com.studentmanagementsystem.service;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectService {
    Student findById(int id);

    List<Subject> findByNameContaining(String name);

    Page<Subject> findAll(Pageable pageable);

    Page<Student> findAllByName(Pageable pageable, String name);
}
