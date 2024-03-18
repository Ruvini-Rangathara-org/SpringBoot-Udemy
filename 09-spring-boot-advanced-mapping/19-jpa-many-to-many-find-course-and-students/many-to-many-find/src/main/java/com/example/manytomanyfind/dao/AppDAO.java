package com.example.manytomanyfind.dao;


import com.example.manytomanyfind.entity.Course;
import com.example.manytomanyfind.entity.Instructor;
import com.example.manytomanyfind.entity.InstructorDetail;
import com.example.manytomanyfind.entity.Student;

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

    void saveCourse(Course course);

    Course findCoursesWithReviewsById(int courseId);

    Course findCourseAndStudentByCourseId(int courseId);

    Student findCourseAndStudentByStudentId(int studentId);
}
