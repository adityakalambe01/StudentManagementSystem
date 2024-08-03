package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.Classroom;
import com.studentmanagementsystem.entity.Homework;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Integer> {
    Classroom save(Classroom classroom);

    Classroom findById(int id);

    Page<Homework> findAll(Pageable pageable);

    List<Homework> findByDateCreated(Date date);

    List<Homework> findByDetailsContaining(String details);

    List<Homework> findByGradeObtained(String grade);

    List<Homework> findByGradeObtainedIsIn(List<String> str);

    List<Homework> findByContentContaining(String content);


}
