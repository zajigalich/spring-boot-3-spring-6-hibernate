package com.udemy.spring_boot_rest_crud.employee.dao;

import com.udemy.spring_boot_rest_crud.employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);

}