package com.udemy.spring_boot_rest_crud.employee.dao.impl;

import com.udemy.spring_boot_rest_crud.employee.dao.EmployeeDao;
import com.udemy.spring_boot_rest_crud.employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

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
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Employee.class, id));
    }

    @Override
    public void update(Employee employee) {
        entityManager.merge(employee);
    }
}
