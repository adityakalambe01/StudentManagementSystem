package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Classroom;
import com.studentmanagementsystem.entity.Homework;
import com.studentmanagementsystem.repo.HomeworkRepository;
import com.studentmanagementsystem.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    private HomeworkRepository homeworkRepository;

    @Override
    public Classroom save(Classroom classroom) {
        return homeworkRepository.save(classroom);
    }

    @Override
    public Classroom findById(int id) {
        return homeworkRepository.findById(id);
    }

    @Override
    public Page<Homework> findAll(Pageable pageable) {
        return homeworkRepository.findAll(pageable);
    }

    @Override
    public List<Homework> findByDateCreated(Date date) {
        return homeworkRepository.findByDateCreated(date);
    }

    @Override
    public List<Homework> findByDetailsContaining(String details) {
        return homeworkRepository.findByDetailsContaining(details);
    }

    @Override
    public List<Homework> findByGradeObtained(String grade) {
        return homeworkRepository.findByGradeObtained(grade);
    }

    @Override
    public List<Homework> findByGradeObtainedIsIn(List<String> str) {
        return homeworkRepository.findByGradeObtainedIsIn(str);
    }

    @Override
    public List<Homework> findByContentContaining(String content) {
        return homeworkRepository.findByContentContaining(content);
    }

    @Override
    public List<Homework> saveAll(List<Homework> list) {
        return homeworkRepository.saveAll(list);
    }
}
