package com.example.employeedemo.dao;

import com.example.employeedemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
}
