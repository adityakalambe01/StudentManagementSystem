package com.studentmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

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

    @Column(nullable = false,length = 25)
    private String street;

    @Column(nullable = false, length = 25)
    private String city;

    @Column(nullable = false, length = 25)
    private String state;

    @Column(nullable = false, length = 10)
    private String zip;

    @Column(nullable = false, length = 40)
    private String country;

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
