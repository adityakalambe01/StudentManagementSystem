package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Teacher;
import com.studentmanagementsystem.repo.TeacherRepository;
import com.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher findById(int id) {
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> findByFirstNameContaining(String firstName) {
        return teacherRepository.findByFirstNameContaining(firstName);
    }

    @Override
    public List<Teacher> findByMiddleNameContaining(String middleName) {
        return teacherRepository.findByMiddleNameContaining(middleName);
    }

    @Override
    public List<Teacher> findByLastNameContaining(String lastName) {
        return teacherRepository.findByLastNameContaining(lastName);
    }

    @Override
    public List<Teacher> findByEmailContaining(String email) {
        return teacherRepository.findByEmailContaining(email);
    }

    @Override
    public List<Teacher> findByPhoneNumberContaining(String phoneNumber) {
        return teacherRepository.findByPhoneNumberContaining(phoneNumber);
    }

    @Override
    public List<Teacher> findByGenderContaining(String gender) {
        return teacherRepository.findByGenderContaining(gender);
    }

    @Override
    public List<Teacher> findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(String firstName, String middleName, String lastName, String email) {
        return teacherRepository.findByFirstNameOrMiddleNameOrLastNameOrEmailContaining(firstName, middleName, lastName, email);
    }

    @Override
    public Page<Teacher> findAll(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public Teacher deleteById(int id) {
        return teacherRepository.deleteById(id);
    }
}
