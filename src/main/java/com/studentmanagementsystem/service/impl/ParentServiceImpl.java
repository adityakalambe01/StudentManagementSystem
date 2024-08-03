package com.studentmanagementsystem.service.impl;

import com.studentmanagementsystem.entity.Parent;
import com.studentmanagementsystem.repo.ParentRepository;
import com.studentmanagementsystem.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentRepository parentRepository;

    @Override
    public Page<Parent> findAll(Pageable pageable) {
        return parentRepository.findAll(pageable);
    }

    @Override
    public Parent findById(int id) {
        return parentRepository.findById(id);
    }

    @Override
    public List<Parent> findByFirstNameContaining(String name) {
        return parentRepository.findByFirstNameContaining(name);
    }

    @Override
    public List<Parent> findByMiddleNameContaining(String name) {
        return parentRepository.findByMiddleNameContaining(name);
    }

    @Override
    public List<Parent> findByLastNameContaining(String name) {
        return parentRepository.findByLastNameContaining(name);
    }

    @Override
    public List<Parent> findByFirstNameAndMiddleNameContaining(String firstName, String middleName) {
        return parentRepository.findByFirstNameAndMiddleNameContaining(firstName, middleName);
    }

    @Override
    public List<Parent> findByLastNameAndFirstNameContaining(String lastName, String firstName) {
        return parentRepository.findByLastNameAndFirstNameContaining(lastName, firstName);
    }

    @Override
    public List<Parent> findByFirstNameAndMiddleNameAndLastNameContaining(String firstName, String middleName, String lastName) {
        return parentRepository.findByFirstNameAndMiddleNameAndLastNameContaining(firstName, middleName, lastName);
    }
}
