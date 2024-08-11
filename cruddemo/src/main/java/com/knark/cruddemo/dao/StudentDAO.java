package com.knark.cruddemo.dao;

import com.knark.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);
    Student findbyId(Integer Id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer Id);
    int deleteALl();
}
