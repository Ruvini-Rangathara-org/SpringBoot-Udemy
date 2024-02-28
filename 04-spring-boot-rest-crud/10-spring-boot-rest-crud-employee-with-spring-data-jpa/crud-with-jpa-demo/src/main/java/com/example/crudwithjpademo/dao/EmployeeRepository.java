package com.example.crudwithjpademo.dao;


import com.example.crudwithjpademo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
