package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Users;
import com.studentmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Users save(@RequestBody Users user) {
        return userService.save(user);
    }

    @PutMapping(value = "/update-user/{userId}")
    public Users updateUser(@PathVariable("userId") String userId, @RequestBody Users user) {
        user.setUserId(userId);
        System.out.println(user);
        return userService.update(user);
    }

    public Page<Users> findAll(Pageable pageable) {
        return userService.findAll(pageable);
    }

    public List<Users> findByRoleContaining(String role, Pageable pageable) {
        return userService.findByRole(role, pageable);
    }

    public List<Users> findAll() {
        return userService.findAll();
    }

    public List<Users> findByFirstNameContaining(String firstName, Pageable pageable) {
        return userService.findByFirstNameContaining(firstName, pageable);
    }

    public List<Users> findByMiddleNameContaining(String middleName, Pageable pageable) {
        return userService.findByMiddleNameContaining(middleName, pageable);
    }

    public List<Users> findByLastNameContaining(String lastName, Pageable pageable) {
        return userService.findByLastNameContaining(lastName, pageable);
    }

    public List<Users> findByFirstNameContainingAndMiddleNameContainingAndLastNameContaining(String firstName, String middleName, String lastName, Pageable pageable) {
        return userService.findByFirstNameContainingAndMiddleNameContainingAndLastNameContaining(firstName, middleName, lastName, pageable);
    }

    public List<Users> findByPhoneNumberContaining(String phoneNumber, Pageable pageable) {
        return userService.findByPhoneNumberContaining(phoneNumber, pageable);
    }

    public List<Users> findByIdSuperAdmin(boolean isSuperAdmin, Pageable pageable) {
        return userService.findByIdSuperAdminAccess(isSuperAdmin, pageable);
    }

    public List<Users> findByIsAdmin(boolean isAdmin, Pageable pageable) {
        return userService.findByIsAdminAccess(isAdmin, pageable);
    }

    public List<Users> findByIsPrinciple(boolean isPrinciple, Pageable pageable) {
        return userService.findByIsPrincipleAccess(isPrinciple, pageable);
    }

    public List<Users> findByIsTeacher(boolean isTeacher, Pageable pageable) {
        return userService.findByIsTeacherAccess(isTeacher, pageable);
    }

    public List<Users> findByIsStudent(boolean isStudent, Pageable pageable) {
        return userService.findByIsStudentAccess(isStudent, pageable);
    }

    public List<Users> findByIsParent(boolean isParent, Pageable pageable) {
        return userService.findByIsParentAccess(isParent, pageable);
    }

    public Users findByUserId(String id) {
        return userService.findByUserId(id);
    }

    @PostMapping(value = "/login-user")
    public Map<String, Object> login(@RequestBody Users users) {
        Map<String, Object> auth = null;
        if (userService.login(users)){
            auth = userService.authData(users);
        }
        return auth;
    }

    @PostMapping(value = "/logout-user")
    public Boolean logout(@RequestBody Users users){
        return userService.logout(users);
    }
}
