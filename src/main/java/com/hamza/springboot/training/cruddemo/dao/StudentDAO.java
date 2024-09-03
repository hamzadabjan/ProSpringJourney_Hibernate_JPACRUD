package com.hamza.springboot.training.cruddemo.dao;

import com.hamza.springboot.training.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save (Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();

    List<Student> findByLastName(String theLastName);
}
