package com.example.findalldemo.dao.impl;

import com.example.findalldemo.dao.StudentDao;
import com.example.findalldemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student order by firstName desc", Student.class);
        List<Student> students = theQuery.getResultList();
        return students;
    }
}
