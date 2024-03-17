package com.example.eagerfinddemo.dao;


import com.example.eagerfinddemo.entity.Instructor;
import com.example.eagerfinddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
