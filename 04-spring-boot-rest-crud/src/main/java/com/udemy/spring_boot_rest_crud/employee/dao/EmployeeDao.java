package com.udemy.spring_boot_rest_crud.employee.dao;

import com.udemy.spring_boot_rest_crud.employee.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(Long id);

    void save(Employee employee);

    void delete(Long id);

    void update(Employee employee);

}
