package com.example.getallwithservicedemo.service.impl;

import com.example.getallwithservicedemo.dao.EmployeeDao;
import com.example.getallwithservicedemo.entity.Employee;
import com.example.getallwithservicedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao theEmployeeDao) {
        employeeDao = theEmployeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
