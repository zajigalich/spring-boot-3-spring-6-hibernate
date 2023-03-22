package com.udemy.hibernate_jpa_crud;

import com.udemy.hibernate_jpa_crud.dao.StudentDao;
import com.udemy.hibernate_jpa_crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudJpaApplication {


    public static void main(String[] args) {
        SpringApplication.run(CrudJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) { //autowiring StudentDao
        return runner -> {
            //createStudent(studentDao);
            //createMultipleStudents(studentDao);
            //readStudent(studentDao);
            //readAllStudents(studentDao);
            //readStudentByLastName(studentDao);
            updateStudent(studentDao);
        };
    }

    private void updateStudent(StudentDao studentDao) {

        Long studentId = 2L;
        System.out.println("Updating lastName of student with the id of " + studentId + " to 'Applebum'");

        Student detachedStudent = studentDao.findById(studentId);

        detachedStudent.setLastName("Applebum");

        studentDao.update(detachedStudent);
    }

    private void readStudentByLastName(StudentDao studentDao) {
        String searchedLastName = "man";

        System.out.println("Reading student with the lastName like '" + searchedLastName + "'");

        List<Student> students = studentDao.findByLastName(searchedLastName);

        students.forEach(System.out::println);
    }

    private void readAllStudents(StudentDao studentDao) {
        System.out.println("Reading all students saved in database");

        List<Student> students = studentDao.findAll();

        students.forEach(System.out::println);
    }

    private void readStudent(StudentDao studentDao) {
        Long id = 2L;
        System.out.println("Reading student with the id of " + id);

        Student student = studentDao.findById(id);

        System.out.println("student = " + student);
    }

    private void createMultipleStudents(StudentDao studentDao) {
        System.out.println("Creating new 2 student objects");
        Student student1 = new Student("Bonita", "Stick", "stick@b.com");
        Student student2 = new Student("Garry", "Potter", "garrt@p.com");

        //managed state
        studentDao.save(student1);
        studentDao.save(student2);

        System.out.println("Generated id: " + student1.getId() + ", " + student2.getId());
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
