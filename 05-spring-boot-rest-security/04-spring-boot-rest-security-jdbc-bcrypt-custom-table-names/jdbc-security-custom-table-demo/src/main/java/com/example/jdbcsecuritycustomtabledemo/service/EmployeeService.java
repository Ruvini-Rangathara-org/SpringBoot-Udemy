package com.example.jdbcsecuritycustomtabledemo.service;



import com.example.jdbcsecuritycustomtabledemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
