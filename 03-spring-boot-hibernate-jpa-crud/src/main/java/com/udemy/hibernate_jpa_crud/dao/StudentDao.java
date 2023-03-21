package com.udemy.hibernate_jpa_crud.dao;

import com.udemy.hibernate_jpa_crud.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);

    Student findById(Long id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Long id);

    void deleteAll();

}
