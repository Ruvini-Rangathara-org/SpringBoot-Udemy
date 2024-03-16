package com.example.deleteonlydetail.dao;


import com.example.deleteonlydetail.entity.Instructor;
import com.example.deleteonlydetail.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
