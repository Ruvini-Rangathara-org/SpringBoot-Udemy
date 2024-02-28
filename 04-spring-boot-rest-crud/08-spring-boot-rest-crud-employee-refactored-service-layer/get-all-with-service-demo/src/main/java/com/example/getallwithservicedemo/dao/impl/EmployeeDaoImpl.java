package com.example.getallwithservicedemo.dao.impl;


import com.example.getallwithservicedemo.dao.EmployeeDao;
import com.example.getallwithservicedemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> fromEmployee = entityManager.createQuery("from Employee", Employee.class);
        return fromEmployee.getResultList();
    }
}
