package com.example.spring_boot_rest_security.service;


import com.example.spring_boot_rest_security.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);

}
