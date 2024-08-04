package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.repo.StudentRepository;
import com.studentmanagementsystem.service.StudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @PostConstruct
    public void init(){
        if(studentRepository.count()==0){
            for (int i = 1; i <= 10000; i++) {
                Student student = new Student();

                student.setEmail(
                        new RandomNameGenerator().next(26,15).toLowerCase()+"@gmail.com"
                );

                student.setFirstName(
                        new RandomNameGenerator().next(26,8)
                );

                student.setMiddleName(
                        new RandomNameGenerator().next(26,8)
                );

                student.setLastName(
                        new RandomNameGenerator().next(26,8)
                );

                student.setPhoneNumber(
                        new RandomNameGenerator().nextIntString(9, 10)
                );

                studentRepository.save(student);
            }
        }
    }
}
