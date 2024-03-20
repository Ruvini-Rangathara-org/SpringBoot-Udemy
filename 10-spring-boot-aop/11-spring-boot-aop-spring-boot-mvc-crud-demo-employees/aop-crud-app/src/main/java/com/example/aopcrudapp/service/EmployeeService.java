package com.example.aopcrudapp.service;

import java.util.List;

import com.example.aopcrudapp.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
