package com.udemy.spring_boot_rest_crud.employee.service.impl;

import com.udemy.spring_boot_rest_crud.employee.dao.EmployeeDAO;
import com.udemy.spring_boot_rest_crud.employee.entity.Employee;
import com.udemy.spring_boot_rest_crud.employee.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;

    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        employee.setId(null);
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        employeeDAO.deleteById(id);
    }

}
