package com.udemy.spring_boot_rest_crud.rest;

import com.udemy.spring_boot_rest_crud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    public void initializeStudents(){
        students = new ArrayList<>();

        students.add(new Student("Paul","Morphy"));
        students.add(new Student("Garry","Potter"));
        students.add(new Student("Magnus", "Carson"));
    }

    @GetMapping
    public List<Student> getStudents(){
        return students;
    }

}
