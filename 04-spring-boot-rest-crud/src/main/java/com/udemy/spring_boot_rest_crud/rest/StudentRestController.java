package com.udemy.spring_boot_rest_crud.rest;

import com.udemy.spring_boot_rest_crud.entity.Student;
import com.udemy.spring_boot_rest_crud.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void initializeStudents() {
        students = new ArrayList<>();

        students.add(new Student("Paul", "Morphy"));
        students.add(new Student("Garry", "Potter"));
        students.add(new Student("Magnus", "Carson"));
    }

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/{idx}")
    public Student getStudent(@PathVariable int idx) {

        if (idx >= students.size() || idx < 0) {
            throw new StudentNotFoundException("Student not found with id =" + idx);
        }

        return students.get(idx);
    }

}
