package com.example.spring_boot_rest_security.rest;

import com.example.spring_boot_rest_security.entity.Employee;
import com.example.spring_boot_rest_security.service.EmployeeService;
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
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id){

        return employeeService.findById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(null);
        return employeeService.save(employee);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){

        Employee employee = employeeService.findById(id);

        employeeService.deleteById(employee.getId());
        return "Deleted employee with id - " + id;
    }
}
