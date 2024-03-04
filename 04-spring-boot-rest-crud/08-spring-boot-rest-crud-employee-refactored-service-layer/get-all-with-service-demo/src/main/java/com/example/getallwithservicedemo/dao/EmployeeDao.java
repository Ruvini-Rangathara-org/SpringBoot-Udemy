package com.example.getallwithservicedemo.dao;


import com.example.getallwithservicedemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
}
