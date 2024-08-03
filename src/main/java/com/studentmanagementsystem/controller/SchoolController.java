package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.School;
import com.studentmanagementsystem.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping("/{schoolId}-school-address-{addressId}")
    public School updateSchoolAddress(@PathVariable("schoolId") int schoolId, @PathVariable("addressId") int addressId) {
        return schoolService.updateSchoolAddress(schoolId, addressId);
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
    public List<School> findAll(){
        return schoolService.findAll();
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
