package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.School;
import com.studentmanagementsystem.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PutMapping(value = "/{schoolId}-school-{addressId}-address")
    public School updateSchoolAddress(@PathVariable("schoolId") int schoolId, @PathVariable("addressId") int addressId) {
        return schoolService.updateSchoolAddress(schoolId, addressId);
    }

    @PutMapping(value = "/{schoolId}-school-{studentId}-student")
    public School updateSchoolStudent(@PathVariable("schoolId") int schoolId,@PathVariable("studentId") int studentId){
        return schoolService.updateSchoolStudent(schoolId, studentId);
    }

    @PutMapping(value = "/{schoolId}-school-{teacherId}-teacher")
    public School updateSchoolTeachers(@PathVariable("schoolId") int schoolId, @PathVariable("teacherId")  int teacherId){
        return schoolService.updateSchoolTeachers(schoolId, teacherId);
    }

    @GetMapping(value = "/{id}")
    public School findById(@PathVariable(value = "id") int id){
        return schoolService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public School deleteById(@PathVariable(value = "id") int id){
        return schoolService.deleteById(id);
    }

    @GetMapping(value = "/school-name-{name}")
    public School findByName(@PathVariable(value = "name") String name){
        return schoolService.findByName(name);
    }

    @GetMapping(value = "/school-{name}-name")
    public List<School> findByNameContaining(@PathVariable(value = "name") String name){
        return schoolService.findByNameContaining(name);
    }


    @GetMapping
    public List<School> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "50", required = false) Integer pageSize
    ){
        return schoolService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping(value = "/school-principle-{principle}")
    public List<School> findByPrincipleContaining(@PathVariable(value = "principle") String principle){
        return schoolService.findByPrincipleContaining(principle);
    }

    @GetMapping(value = "/school-details-{details}")
    public List<School> findByDetailsContaining(@PathVariable(value = "details") String details){
        return schoolService.findByDetailsContaining(details);
    }
}
