package com.example.crudreaddemo.dao;


import com.example.crudreaddemo.entity.Student;

public interface StudentDao {
    void save(Student student);

    Student findById(Integer id);
}
