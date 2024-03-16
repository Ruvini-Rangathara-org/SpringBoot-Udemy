package com.example.jpabideletedemo.dao;


import com.example.jpabideletedemo.entity.Instructor;
import com.example.jpabideletedemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
