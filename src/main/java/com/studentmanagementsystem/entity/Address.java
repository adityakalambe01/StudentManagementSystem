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
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;

    private String area;

    private Integer zip;

    private String district;

    private String state;

    @OneToOne
    @ToString.Exclude
    private School school;

    @ManyToMany
    @ToString.Exclude
    @JoinTable(name = "addresseList")
    private List<Parent> parentsList;

    @ManyToMany
    @ToString.Exclude
    @JoinTable(name = "addresses")
    private List<Student> students;
}
