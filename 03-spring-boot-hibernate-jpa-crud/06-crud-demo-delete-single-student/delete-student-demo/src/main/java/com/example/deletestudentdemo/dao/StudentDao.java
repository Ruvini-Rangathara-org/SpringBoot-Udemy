package com.example.deletestudentdemo.dao;


import com.example.deletestudentdemo.entity.Student;

public interface StudentDao {
    Student findById(Integer id);
    void delete(Integer id);
    int deleteByEmail(String email);
}
