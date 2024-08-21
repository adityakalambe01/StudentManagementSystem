package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Users;
import com.studentmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/users")
public class UserController {
    @Autowired
    private UserService userService;

    /*
    *
    * Add New User
    *
    * */
    @PostMapping
    public Users save(@RequestBody Users user) {
        return userService.save(user);
    }

    /*
    *
    * Update Existing an User
    *
    * */
    @PutMapping(value = "/update-user/{userId}")
    public Users updateUser(@PathVariable("userId") String userId, @RequestBody Users user) {
        user.setUserId(userId);
        System.out.println(user);
        return userService.update(user);
    }

    /*
    *
    * Get List of User
    *
    * */
    public Page<Users> findAll(Pageable pageable) {
        return userService.findAll(pageable);
    }

    /*
    *
    * Get User List by Role
    *
    * */
    public List<Users> findByRoleContaining(String role, Pageable pageable) {
        return userService.findByRole(role, pageable);
    }

    /*
    *
    * Get List of User's by Pagination
    *
    * */
    public List<Users> findAll() {
        return userService.findAll();
    }

    /*
    *
    * Get User List by First-Name
    *
    * */
    public List<Users> findByFirstNameContaining(String firstName, Pageable pageable) {
        return userService.findByFirstNameContaining(firstName, pageable);
    }

    /*
    *
    * Get User List by Middle-Name
    *
    * */
    public List<Users> findByMiddleNameContaining(String middleName, Pageable pageable) {
        return userService.findByMiddleNameContaining(middleName, pageable);
    }

    /*
    *
    * Get User List by Last-Name
    *
    * */
    public List<Users> findByLastNameContaining(String lastName, Pageable pageable) {
        return userService.findByLastNameContaining(lastName, pageable);
    }

    /*
    *
    * Get User List by First-Name, Middle-Name and Last-Name
    *
    * */
    public List<Users> findByFirstNameContainingAndMiddleNameContainingAndLastNameContaining(String firstName, String middleName, String lastName, Pageable pageable) {
        return userService.findByFirstNameContainingAndMiddleNameContainingAndLastNameContaining(firstName, middleName, lastName, pageable);
    }

    /*
    *
    * Get User List by Phone Number
    *
    * */
    public List<Users> findByPhoneNumberContaining(String phoneNumber, Pageable pageable) {
        return userService.findByPhoneNumberContaining(phoneNumber, pageable);
    }

    /*
    *
    * Check User is Super Admin Access
    *
    * */
    public List<Users> findByIdSuperAdmin(boolean isSuperAdmin, Pageable pageable) {
        return userService.findByIdSuperAdminAccess(isSuperAdmin, pageable);
    }

    /*
    *
    * Check User is Admin Access
    *
    * */
    public List<Users> findByIsAdmin(boolean isAdmin, Pageable pageable) {
        return userService.findByIsAdminAccess(isAdmin, pageable);
    }

    /*
    *
    * Check User is Principle Access
    *
    * */
    public List<Users> findByIsPrinciple(boolean isPrinciple, Pageable pageable) {
        return userService.findByIsPrincipleAccess(isPrinciple, pageable);
    }

    /*
    *
    * Check User is Teacher Access
    *
    * */
    public List<Users> findByIsTeacher(boolean isTeacher, Pageable pageable) {
        return userService.findByIsTeacherAccess(isTeacher, pageable);
    }

    /*
    *
    * Check User is Student Access
    *
    * */
    public List<Users> findByIsStudent(boolean isStudent, Pageable pageable) {
        return userService.findByIsStudentAccess(isStudent, pageable);
    }

    /*
    *
    * Check User is Parent Access
    *
    * */
    public List<Users> findByIsParent(boolean isParent, Pageable pageable) {
        return userService.findByIsParentAccess(isParent, pageable);
    }

    /*
    *
    * Get User by ID
    *
    * */
    public Users findByUserId(String id) {
        return userService.findByUserId(id);
    }

    /*
    *
    * User Login
    *
    * */
    @PostMapping(value = "/login-user")
    public Map<String, Object> login(@RequestBody Users users) {
        Map<String, Object> auth = null;
        if (userService.login(users)){
            auth = userService.authData(users);
        }
        return auth;
    }

    /*
    *
    * User Logout
    *
    * */
    @PostMapping(value = "/logout-user")
    public Boolean logout(@RequestBody Users users){
        return userService.logout(users);
    }
}
