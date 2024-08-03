package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Report;
import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.repo.ReportRepository;
import com.studentmanagementsystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Page<Report> findAll(Pageable pageable) {
        return reportRepository.findAll(pageable);
    }

    @Override
    public Report findById(int id) {
        return reportRepository.findById(id);
    }

    @Override
    public Report deleteById(int id) {
        return reportRepository.deleteById(id);
    }

    @Override
    public List<Report> findByDateCreated(Date created) {
        return reportRepository.findByDateCreated(created);
    }

    @Override
    public List<Report> findByContentContaining(String content) {
        return reportRepository.findByContentContaining(content);
    }

    @Override
    public List<Report> findByTeacherCommentContaining(String comment) {
        return reportRepository.findByTeacherCommentContaining(comment);
    }

    @Override
    public List<Report> findByStudent(Student student) {
        return reportRepository.findByStudent(student);
    }
}
