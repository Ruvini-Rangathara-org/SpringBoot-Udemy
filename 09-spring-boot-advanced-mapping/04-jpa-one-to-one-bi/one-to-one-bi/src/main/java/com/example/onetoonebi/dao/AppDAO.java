package com.example.onetoonebi.dao;


import com.example.onetoonebi.entity.Instructor;
import com.example.onetoonebi.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);
}
