package com.example.jdbcsecuiritydemo.service;


import com.example.jdbcsecuiritydemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
