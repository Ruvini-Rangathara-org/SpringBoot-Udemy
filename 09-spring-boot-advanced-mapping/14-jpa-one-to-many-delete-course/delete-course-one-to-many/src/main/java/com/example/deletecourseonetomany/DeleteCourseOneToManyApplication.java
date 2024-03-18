package com.example.deletecourseonetomany;

import com.example.deletecourseonetomany.dao.AppDAO;
import com.example.deletecourseonetomany.entity.Course;
import com.example.deletecourseonetomany.entity.Instructor;
import com.example.deletecourseonetomany.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeleteCourseOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeleteCourseOneToManyApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AppDAO appDAO) {
		return (args) -> {
			System.out.println("Hello World");
//			createInstructorWithCourses(appDAO);
//			findCourse(appDAO);
//			deleteInstructor(appDAO);
			deleteCourse(appDAO);

		};
	}

	private void deleteCourse(AppDAO appDAO) {
		appDAO.deleteCourse(22);
		System.out.println("Course deleted");
	}

	private void deleteInstructor(AppDAO appDAO) {
		appDAO.deleteById(8);
		System.out.println("Instructor deleted");
	}

	private void findCourse(AppDAO appDAO) {
		Course course = appDAO.findCourseById(15);
		System.out.println("Course found: " + course);
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Susan", "Public", "susan.public@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.test.com",
						"Video test");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Course 1");
		Course tempCourse2 = new Course("Course 2");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE: this will ALSO save the courses
		// because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}
