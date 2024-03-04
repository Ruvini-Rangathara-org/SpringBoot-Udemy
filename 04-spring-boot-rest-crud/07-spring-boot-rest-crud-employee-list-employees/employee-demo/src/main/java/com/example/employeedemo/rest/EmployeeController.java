package com.example.employeedemo.rest;

import com.example.employeedemo.dao.EmployeeDao;
import com.example.employeedemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeController(EmployeeDao theEmployeeDao) {
        employeeDao = theEmployeeDao;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        List<Employee> all = employeeDao.findAll();
        return all;
    }
}
