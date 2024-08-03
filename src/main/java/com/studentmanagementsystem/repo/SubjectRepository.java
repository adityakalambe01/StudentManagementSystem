package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Student findById(int id);

    List<Subject> findByNameContaining(String name);

    Page<Subject> findAll(Pageable pageable);

    Page<Student> findAllByName(Pageable pageable, String name);
}
