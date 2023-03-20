package com.udemy.hibernate_jpa_crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return runner -> System.out.println("Hello World");
    }
}
