package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Classroom;
import com.studentmanagementsystem.entity.Homework;
import com.studentmanagementsystem.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/homework")
public class HomeworkController{
    @Autowired
    private HomeworkService service;

    @PostMapping
    public Homework save(@RequestBody Homework homework) {
        return service.save(homework);
    }

    @GetMapping("/{id}")
    public Homework findById(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Homework> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "50", required = false) Integer pageSize
    ) {
        return service.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @GetMapping("date-created-{date}")
    public List<Homework> findByDateCreated(@PathVariable("date") Date date) {
        return service.findByDateCreated(date);
    }

    @GetMapping("homework-details-{details}")
    public List<Homework> findByDetailsContaining(@PathVariable String details) {
        return service.findByDetailsContaining(details);
    }

    @GetMapping("grade-obtained-{grade}")
    public List<Homework> findByGradeObtained(@PathVariable("grade") String grade) {
        return service.findByGradeObtained(grade);
    }

    @GetMapping("grade-in-{str}")
    public List<Homework> findByGradeObtainedIsIn(@PathVariable("str") List<String> str) {
        System.out.println(str);
        return service.findByGradeObtainedIsIn(str);
    }

    @GetMapping("/content-{content}")
    public List<Homework> findByContentContaining(@PathVariable("content") String content) {
        return service.findByContentContaining(content);
    }

    @PostMapping("/save-all")
    public List<Homework> saveAll(@RequestBody List<Homework> list) {
        return service.saveAll(list);
    }

}
