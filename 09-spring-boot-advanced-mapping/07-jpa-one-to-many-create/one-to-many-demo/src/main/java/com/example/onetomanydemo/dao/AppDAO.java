package com.example.onetomanydemo.dao;

import com.example.onetomanydemo.entity.Instructor;
import com.example.onetomanydemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
