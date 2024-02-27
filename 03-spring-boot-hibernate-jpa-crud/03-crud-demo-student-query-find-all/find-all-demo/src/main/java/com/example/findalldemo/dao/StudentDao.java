package com.example.findalldemo.dao;


import com.example.findalldemo.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
}
