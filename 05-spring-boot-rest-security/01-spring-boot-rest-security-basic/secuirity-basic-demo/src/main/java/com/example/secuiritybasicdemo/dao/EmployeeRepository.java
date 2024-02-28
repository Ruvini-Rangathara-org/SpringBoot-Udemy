package com.example.secuiritybasicdemo.dao;


import com.example.secuiritybasicdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
