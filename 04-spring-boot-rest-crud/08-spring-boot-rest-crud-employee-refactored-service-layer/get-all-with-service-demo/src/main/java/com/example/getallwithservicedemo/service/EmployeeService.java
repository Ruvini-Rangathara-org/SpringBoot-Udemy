package com.example.getallwithservicedemo.service;

import com.example.getallwithservicedemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
}
