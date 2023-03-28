package com.example.spring_boot_rest_security.dao;

import com.example.spring_boot_rest_security.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
