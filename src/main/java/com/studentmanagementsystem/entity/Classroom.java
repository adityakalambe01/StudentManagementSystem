package com.studentmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "classroom")
    private List<Subject> subjectList;

    @ManyToOne
    @ToString.Exclude
    private Teacher teacher;

    @ManyToMany
    @ToString.Exclude
    @JoinTable(name = "classes")
    private List<Student> studentsInClassroom;
}
