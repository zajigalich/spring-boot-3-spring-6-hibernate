package com.udemy.spring_boot_rest_crud.employee.dao;

import com.udemy.spring_boot_rest_crud.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
