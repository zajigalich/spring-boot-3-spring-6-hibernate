package com.udemy.spring_boot_rest_crud.employee.rest;

import com.udemy.spring_boot_rest_crud.employee.entity.Employee;
import com.udemy.spring_boot_rest_crud.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){

        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee id not found" + id);
        }

        return employee;
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        employee.setId(null);
        return employeeService.save(employee);
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        employeeService.deleteById(id);
    }
}
