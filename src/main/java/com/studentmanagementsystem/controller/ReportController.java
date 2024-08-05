package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Report;
import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<Report> findAll(Pageable pageable){
        return reportService.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public Report findById(@PathVariable(value = "id") int id){
        return reportService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public Report deleteById(@PathVariable(value = "id")int id){
        return reportService.deleteById(id);
    }

    @GetMapping(value = "/date-{date}")
    public List<Report> findByDateCreated(@PathVariable(value = "date") Date created){
        return reportService.findByDateCreated(created);
    }

    @GetMapping(value = "/content-{content}")
    public List<Report> findByContentContaining(@PathVariable(value = "content") String content){
        return reportService.findByContentContaining(content);
    }

    @GetMapping(value = "/teacher-comment-{teacherComment}")
    public List<Report> findByTeacherCommentContaining(@PathVariable(value = "teacherComment") String comment){
        return reportService.findByTeacherCommentContaining(comment);
    }

    @GetMapping(value = "/student-{student}")
    public List<Report> findByStudent(@PathVariable(value = "student") Student student){
        return reportService.findByStudent(student);
    }
}
