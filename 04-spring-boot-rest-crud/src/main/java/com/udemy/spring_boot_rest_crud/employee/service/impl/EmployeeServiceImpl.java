package com.udemy.spring_boot_rest_crud.employee.service.impl;

import com.udemy.spring_boot_rest_crud.employee.dao.EmployeeRepository;
import com.udemy.spring_boot_rest_crud.employee.entity.Employee;
import com.udemy.spring_boot_rest_crud.employee.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Supplier;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /* Best practice is to use spring data

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }*/

    @Override
    //@Transactional(readOnly = true) no need for @transactional because JpaRepository provides
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
