package com.udemy.spring_boot_rest_crud.student.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloWorldRestController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }
}
