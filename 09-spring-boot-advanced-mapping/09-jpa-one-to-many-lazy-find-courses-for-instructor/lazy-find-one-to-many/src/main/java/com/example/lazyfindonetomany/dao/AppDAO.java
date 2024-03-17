package com.example.lazyfindonetomany.dao;


import com.example.lazyfindonetomany.entity.Course;
import com.example.lazyfindonetomany.entity.Instructor;
import com.example.lazyfindonetomany.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int theId);

}
