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
    //@Transactional - no need for transaction support because we are using a read-only query
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    //@Transactional
    public List<Student> findAll() {
        return entityManager.createQuery("select s from Student s order by s.lastName", Student.class).getResultList();
    }

    @Override
    //@Transactional
    public List<Student> findByLastName(String lastName) {

        TypedQuery<Student> query = entityManager
                .createQuery("select s from Student s where lower(s.lastName) like :theLastName", Student.class);

        query.setParameter("theLastName", "%" + lastName.toLowerCase() + "%");

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Student.class, id));
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("delete from Student").executeUpdate();
    }
}
