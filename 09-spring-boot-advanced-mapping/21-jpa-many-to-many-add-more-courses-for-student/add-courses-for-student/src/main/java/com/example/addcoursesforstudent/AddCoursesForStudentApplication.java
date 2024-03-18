package com.example.addcoursesforstudent;

import com.example.addcoursesforstudent.dao.AppDAO;
import com.example.addcoursesforstudent.entity.Course;
import com.example.addcoursesforstudent.entity.Review;
import com.example.addcoursesforstudent.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddCoursesForStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddCoursesForStudentApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(AppDAO appDAO) {
		return (args) -> {
//			createCourseAndStudents(appDAO);
//			findCourseAndStudentByCourseId(appDAO);
//			findCourseAndStudentByStudentId(appDAO);

			addMoreCoursesForStudent(appDAO);
		};
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int id=1;
		Student student = appDAO.findCourseAndStudentByStudentId(id);

		Course course1 = new Course("Course 2");
		Course course2 = new Course("Course 3");

		student.addCourse(course1);
		student.addCourse(course2);

		appDAO.updateStudent(student);
		System.out.println("Done!");
	}

	private void findCourseAndStudentByStudentId(AppDAO appDAO) {
		// get the student
		Student student = appDAO.findCourseAndStudentByStudentId(1);

		// print the student
		System.out.println("Student: " + student);

		// print the courses
		System.out.println("Courses: " + student.getCourses());
		System.out.println("Done!");
	}

	private void findCourseAndStudentByCourseId(AppDAO appDAO) {
		// get the course
		Course course = appDAO.findCourseAndStudentByCourseId(10);

		// print the course
		System.out.println("Course: " + course);

		// print the students
		System.out.println("Students: " + course.getStudents());
		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course = new Course("Course 1");

		// create the students
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");

		// add students to the course
		course.addStudent(tempStudent1);
		course.addStudent(tempStudent2);

		// save the course and associated students
		appDAO.saveCourse(course);

	}

	private void deleteCourse(AppDAO appDAO) {
		// get the course
		Course course = appDAO.findCoursesWithReviewsById(12);

		// delete the course
		appDAO.deleteCourse(course.getId());
		System.out.println("Deleted course: " + course);
		System.out.println("Done!");
	}

	private void findCourseAndReviewsByCourseId(AppDAO appDAO) {
		// get the course
		Course course = appDAO.findCoursesWithReviewsById(10);

		// print the course
		System.out.println("Course: " + course);

		// print the course reviews
		System.out.println("Reviews: " + course.getReviews());
		System.out.println("Done!");
	}

	private void saveCourse(AppDAO appDAO) {
		// create a course
		Course course = new Course("Course 1");

		// add some reviews
		course.addReview(new Review("Great course ... loved it!"));
		course.addReview(new Review("Cool course, job well done"));
		course.addReview(new Review("What a dumb course, you are an idiot!"));

		// save the course ... and leverage the cascade all :-)
		appDAO.saveCourse(course);
		System.out.println("Saved course: " + course);
	}
}
