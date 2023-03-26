package com.udemy.spring_boot_rest_crud.employee.dao.impl;

import com.udemy.spring_boot_rest_crud.employee.dao.EmployeeDAO;
import com.udemy.spring_boot_rest_crud.employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        return entityManager
                .createQuery("select e from Employee e", Employee.class)
                .getResultList();
    }

    @Override
    public Employee findById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        //merge performs insert if id == null, otherwise performs update
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(Long id) {
         entityManager.remove(entityManager.find(Employee.class, id));
    }
}
