package com.example.spring_boot_rest_security.service.impl;

import com.example.spring_boot_rest_security.dao.EmployeeRepository;
import com.example.spring_boot_rest_security.entity.Employee;
import com.example.spring_boot_rest_security.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Did not find employee with id of " + id));
    }

    @Override
    public Employee save(Employee employee) {
        employee.setId(null);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

}
