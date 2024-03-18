package com.example.deletecourseonetomany.dao;


import com.example.deletecourseonetomany.entity.Course;
import com.example.deletecourseonetomany.entity.Instructor;
import com.example.deletecourseonetomany.entity.InstructorDetail;

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

    void deleteCourse(int courseId);
}
