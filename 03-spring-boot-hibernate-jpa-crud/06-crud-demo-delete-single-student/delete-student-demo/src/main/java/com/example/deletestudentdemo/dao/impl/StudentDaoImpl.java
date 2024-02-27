package com.example.deletestudentdemo.dao.impl;


import com.example.deletestudentdemo.dao.StudentDao;
import com.example.deletestudentdemo.entity.Student;
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


    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);

    }

    @Transactional
    @Override
    public int deleteByEmail(String email) {
        int i = entityManager.createQuery("DELETE FROM Student WHERE email=:theEmail")
                .setParameter("theEmail", email)
                .executeUpdate();
        return i;
    }


}
