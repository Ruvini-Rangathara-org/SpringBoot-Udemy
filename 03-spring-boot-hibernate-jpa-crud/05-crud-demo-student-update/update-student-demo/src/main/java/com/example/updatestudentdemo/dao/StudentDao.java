package com.example.updatestudentdemo.dao;


import com.example.updatestudentdemo.entity.Student;

public interface StudentDao {
    Student findById(Integer id);
    void update(Student theStudent);
}
