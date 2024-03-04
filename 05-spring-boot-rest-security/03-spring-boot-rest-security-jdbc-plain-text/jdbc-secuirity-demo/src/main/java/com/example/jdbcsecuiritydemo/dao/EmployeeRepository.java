package com.example.jdbcsecuiritydemo.dao;


import com.example.jdbcsecuiritydemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
