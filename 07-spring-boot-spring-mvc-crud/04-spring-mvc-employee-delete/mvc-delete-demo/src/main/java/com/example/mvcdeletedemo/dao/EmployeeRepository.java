package com.example.mvcdeletedemo.dao;

import com.example.mvcdeletedemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // find all by last name asc
    public List<Employee> findAllByOrderByFirstNameAsc();

}
