package com.example.deletealldemo.dao.impl;

import com.example.deletealldemo.dao.StudentDao;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
