package com.example.manytomanydelete.dao;


import com.example.manytomanydelete.entity.Course;
import com.example.manytomanydelete.entity.Instructor;
import com.example.manytomanydelete.entity.InstructorDetail;
import com.example.manytomanydelete.entity.Student;

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

    void deleteStudent(int studentId);
}
