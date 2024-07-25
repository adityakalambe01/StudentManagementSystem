package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Integer> {
}
