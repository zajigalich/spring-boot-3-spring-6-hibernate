package com.udemy.hibernate_jpa_crud.dao.impl;

import com.udemy.hibernate_jpa_crud.dao.StudentDao;
import com.udemy.hibernate_jpa_crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return entityManager.createQuery("select Student from Student ", Student.class).getResultList();
    }

    @Override
    @Transactional
    public List<Student> findByLastName(String lastName) {

        TypedQuery<Student> query = entityManager
                .createQuery("select Student from Student where lastName like :theLastName", Student.class);

        query.setParameter("theLastName", lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.refresh(student);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        //entityManager.remove();
    }

    @Override
    @Transactional
    public void deleteAll() {

    }
}
