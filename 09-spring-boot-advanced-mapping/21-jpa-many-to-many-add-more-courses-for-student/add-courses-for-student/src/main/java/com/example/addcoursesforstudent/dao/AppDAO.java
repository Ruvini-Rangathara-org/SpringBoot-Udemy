package com.example.addcoursesforstudent.dao;


import com.example.addcoursesforstudent.entity.Course;
import com.example.addcoursesforstudent.entity.Instructor;
import com.example.addcoursesforstudent.entity.InstructorDetail;
import com.example.addcoursesforstudent.entity.Student;

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

    void updateStudent(Student student);
}
