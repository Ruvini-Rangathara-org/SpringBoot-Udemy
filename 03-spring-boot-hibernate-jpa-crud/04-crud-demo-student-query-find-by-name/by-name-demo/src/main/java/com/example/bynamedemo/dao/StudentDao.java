package com.example.bynamedemo.dao;


import com.example.bynamedemo.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAllByLastName(String lastName);
}
