package com.example.updateinstructoronetomany.dao;


import com.example.updateinstructoronetomany.entity.Course;
import com.example.updateinstructoronetomany.entity.Instructor;
import com.example.updateinstructoronetomany.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor instructor);
}
