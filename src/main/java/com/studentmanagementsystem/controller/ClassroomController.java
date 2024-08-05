package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Classroom;
import com.studentmanagementsystem.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @PostMapping
    public Classroom save(Classroom classroom) {
        return classroomService.save(classroom);
    }

    @GetMapping("/{id}")
    public Classroom findById(@PathVariable("id") int id) {
        return classroomService.findById(id);
    }

    @GetMapping
    public List<Classroom> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "50", required = false) Integer pageSize
    ) {
        return classroomService.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @GetMapping("/name-{name}")
    public Classroom findByName(@PathVariable("name") String name) {
        return classroomService.findByName(name);
    }

    @GetMapping("/code-{code}")
    public Classroom findByCode(@PathVariable("code") String code) {
        return classroomService.findByCode(code);
    }

    @DeleteMapping("/{id}")
    public Classroom deleteById(@PathVariable("id") int id) {
        return classroomService.deleteById(id);
    }

    @DeleteMapping("/code-{code}")
    public Classroom deleteByCode(@PathVariable("code") String code) {
        return classroomService.deleteByCode(code);
    }

    @DeleteMapping("/name-{name}")
    public Classroom deleteByName(@PathVariable("name") String name) {
        return classroomService.deleteByName(name);
    }

}
