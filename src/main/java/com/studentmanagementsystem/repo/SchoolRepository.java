package com.studentmanagementsystem.repo;

import com.studentmanagementsystem.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {
    School findById(int id);

    School save(School school);

    School deleteById(int id);

    School findByName(String name);

    List<School> findByNameContaining(String name);

    List<School> findAll();

    List<School> findByPrincipleContaining(String principle);

    List<School> findByDetailsContaining(String details);

}
