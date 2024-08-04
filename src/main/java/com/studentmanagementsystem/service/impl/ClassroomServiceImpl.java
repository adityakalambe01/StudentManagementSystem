package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Classroom;
import com.studentmanagementsystem.repo.ClassroomRepository;
import com.studentmanagementsystem.service.ClassroomService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@Transactional
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom findById(int id) {
        return classroomRepository.findById(id);
    }

    @Override
    public Classroom findByName(String name) {
        return classroomRepository.findByName(name);
    }

    @Override
    public Classroom findByCode(String code) {
        return classroomRepository.findByCode(code);
    }

    @Override
    public Page<Classroom> findAll(Pageable pageable) {
        return classroomRepository.findAll(pageable);
    }

    @Override
    public Classroom deleteById(int id) {
        return classroomRepository.deleteById(id);
    }

    @Override
    public Classroom deleteByCode(String code) {
        return classroomRepository.deleteByCode(code);
    }

    @Override
    public Classroom deleteByName(String name) {
        return classroomRepository.deleteByName(name);
    }

    @PostConstruct
    public void init() {
        if (classroomRepository.count() == 0) {
            for (int i = 1; i <= 100; i++) {
                Classroom classroom = new Classroom();

                classroom.setCode(new RandomNameGenerator().next(26, 3));

                classroom.setName(new RandomNameGenerator().next(26, 5));

                classroomRepository.save(classroom);
            }
        }
    }
}
