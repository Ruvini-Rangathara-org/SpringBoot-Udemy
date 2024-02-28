package com.example.crudemployeedemo.dao.impl;


import com.example.crudemployeedemo.dao.EmployeeDao;
import com.example.crudemployeedemo.entity.Employee;
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

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        employee.setId(dbEmployee.getId());
        return employee;
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Employee.class, id));
    }
}
