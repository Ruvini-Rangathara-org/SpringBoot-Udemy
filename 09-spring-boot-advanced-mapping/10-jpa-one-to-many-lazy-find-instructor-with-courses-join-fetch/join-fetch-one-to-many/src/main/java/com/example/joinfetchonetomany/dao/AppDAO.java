package com.example.joinfetchonetomany.dao;


import com.example.joinfetchonetomany.entity.Course;
import com.example.joinfetchonetomany.entity.Instructor;
import com.example.joinfetchonetomany.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

}
