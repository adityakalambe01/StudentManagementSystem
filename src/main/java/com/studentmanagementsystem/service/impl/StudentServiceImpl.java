package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.repo.StudentRepository;
import com.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student findByEmailContaining(String email) {
        return studentRepository.findByEmailContaining(email);
    }

    @Override
    public Student findByEmailContaining(String email, int schoolId) {
        return studentRepository.findByEmailContaining(email, schoolId);
    }

    @Override
    public List<Student> findByPhoneNumber(String mobile) {
        return studentRepository.findByPhoneNumber(mobile);
    }

    @Override
    public List<Student> findByFirstNameContaining(String firstName) {
        return studentRepository.findByFirstNameContaining(firstName);
    }

    @Override
    public List<Student> findByMiddleNameContaining(String middleName) {
        return studentRepository.findByMiddleNameContaining(middleName);
    }

    @Override
    public List<Student> findByLastNameContaining(String lastName) {
        return studentRepository.findByLastNameContaining(lastName);
    }

    @Override
    public List<Student> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(String firstName, String middleName, String lastName, String email) {
        return studentRepository.findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(firstName, middleName, lastName, email);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student deleteById(int id) {
        return studentRepository.deleteById(id);
    }
}
