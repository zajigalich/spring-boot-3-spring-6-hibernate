package com.udemy.spring_boot_rest_crud.employee.dao;

import com.udemy.spring_boot_rest_crud.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@Repository - optional
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
