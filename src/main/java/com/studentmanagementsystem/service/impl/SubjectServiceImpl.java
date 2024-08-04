package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.entity.Subject;
import com.studentmanagementsystem.repo.SubjectRepository;
import com.studentmanagementsystem.service.SubjectService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Student findById(int id) {
        return subjectRepository.findById(id);
    }

    @Override
    public List<Subject> findByNameContaining(String name) {
        return subjectRepository.findByNameContaining(name);
    }

    @Override
    public Page<Subject> findAll(Pageable pageable) {
        return subjectRepository.findAll(pageable);
    }

    @Override
    public Page<Student> findAllByName(Pageable pageable, String name) {
        return subjectRepository.findAllByName(pageable, name);
    }

    @PostConstruct
    public void init() {
        if (subjectRepository.count() == 0) {
            for (int i = 1; i <= 100000; i++) {
                Subject subject = new Subject();

                subject.setName(
                        new RandomNameGenerator().next(26, 8)
                );

                subjectRepository.save(subject);
            }
        }
    }
}
