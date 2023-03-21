package com.udemy.hibernate_jpa_crud;

import com.udemy.hibernate_jpa_crud.dao.StudentDao;
import com.udemy.hibernate_jpa_crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudJpaApplication {

    private final StudentDao studentDao;

    public CrudJpaApplication(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(CrudJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return runner -> createStudent(studentDao);
    }

    private void createStudent(StudentDao studentDao) {
        //transient state
        Student student = new Student("Sem", "Hartman", "sema@big.com");
        System.out.println("Creating new student object: " + student);

        //managed state
        studentDao.save(student);

        System.out.println("Generated id: " + student.getId());
    }
}
