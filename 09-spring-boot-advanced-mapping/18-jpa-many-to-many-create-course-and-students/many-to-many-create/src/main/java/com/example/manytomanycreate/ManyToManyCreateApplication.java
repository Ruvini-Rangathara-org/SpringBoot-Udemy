package com.example.manytomanycreate;

import com.example.manytomanycreate.dao.AppDAO;
import com.example.manytomanycreate.entity.Course;
import com.example.manytomanycreate.entity.Review;
import com.example.manytomanycreate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManyToManyCreateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyCreateApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(AppDAO appDAO) {
		return (args) -> {
			createCourseAndStudents(appDAO);

		};
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
