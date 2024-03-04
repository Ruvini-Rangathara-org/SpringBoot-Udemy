package com.example.jdbcsecuritycustomtabledemo.dao;


import com.example.jdbcsecuritycustomtabledemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
