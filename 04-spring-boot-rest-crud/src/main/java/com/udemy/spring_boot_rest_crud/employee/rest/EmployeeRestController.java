package com.udemy.spring_boot_rest_crud.employee.rest;

import com.udemy.spring_boot_rest_crud.employee.dao.EmployeeDAO;
import com.udemy.spring_boot_rest_crud.employee.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
