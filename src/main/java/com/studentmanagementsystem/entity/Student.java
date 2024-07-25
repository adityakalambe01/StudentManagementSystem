package com.studentmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String phoneNumber;

    @ManyToMany
    @ToString.Exclude
    private List<Classroom> classes;

    @ToString.Exclude
    @OneToMany(mappedBy = "student")
    private List<Report> reportList;

    @ToString.Exclude
    @OneToMany(mappedBy = "student")
    private List<Homework> homeworkList;

    @ManyToMany
    @ToString.Exclude
    private List<Parent> parents;

    @ManyToMany
    @ToString.Exclude
    private List<Address> addresses;
}
