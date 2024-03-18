package com.example.updatecourseonetomany.dao;


import com.example.updatecourseonetomany.entity.Course;
import com.example.updatecourseonetomany.entity.Instructor;
import com.example.updatecourseonetomany.entity.InstructorDetail;

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

    Course findCourseById(int courseId);

    void updateCourse(Course course);
}
