package com.example.manytomanydelete.dao;

import com.example.manytomanydelete.entity.Course;
import com.example.manytomanydelete.entity.Instructor;
import com.example.manytomanydelete.entity.InstructorDetail;
import com.example.manytomanydelete.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        System.out.println("Instructor found: " + instructor);
        for (Course course : instructor.getCourses()) {
            course.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        System.out.println("Instructor detail found: " + instructorDetail);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);
        // execute query
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                        "JOIN FETCH i.courses " +
                        "JOIN FETCH i.instructorDetail " +
                        "where i.id = :theInstructorId",
                Instructor.class);
        query.setParameter("theInstructorId", theId);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(int courseId) {
        return entityManager.find(Course.class, courseId);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourse(int courseId) {
        Course course = entityManager.find(Course.class, courseId);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCoursesWithReviewsById(int courseId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        "left join fetch c.reviews " +
                        "where c.id = :courseId", Course.class);
        query.setParameter("courseId", courseId);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Course findCourseAndStudentByCourseId(int courseId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        "left join fetch c.students " +
                        "where c.id = :courseId", Course.class);
        query.setParameter("courseId", courseId);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Student findCourseAndStudentByStudentId(int studentId) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select c from Student c " +
                        "left join fetch c.courses " +
                        "where c.id = :studentId", Student.class);
        query.setParameter("studentId", studentId);
        Student student = query.getSingleResult();
        return student;
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int studentId) {
        Student student = entityManager.find(Student.class, studentId);
        entityManager.remove(student);
    }
}
