package com.example.updatecourseonetomany;

import com.example.updatecourseonetomany.dao.AppDAO;
import com.example.updatecourseonetomany.entity.Course;
import com.example.updatecourseonetomany.entity.Instructor;
import com.example.updatecourseonetomany.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UpdateCourseOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpdateCourseOneToManyApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AppDAO appDAO) {
		return (args) -> {
			System.out.println("Hello World");
//			createInstructorWithCourses(appDAO);
//			updateInstructor(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO);

			updateCourse(appDAO);
//			findCourse(appDAO);
			findInstructorWithCoursesJoinFetch(appDAO);
		};
	}

	private void findCourse(AppDAO appDAO) {
		Course course = appDAO.findCourseById(15);
		System.out.println("Course found: " + course);
	}

	private void updateCourse(AppDAO appDAO) {
		Course course = appDAO.findCourseById(15);
		System.out.println("Course found: " + course);
		course.setTitle("Spring Boot");
		System.out.println("Course updated: " + course);
		appDAO.updateCourse(course);
	}


	private void updateInstructor(AppDAO appDAO) {
		Instructor instructor = appDAO.findById(4);
		System.out.println("Instructor found: " + instructor);
		instructor.setLastName("Tester");
		appDAO.update(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		Instructor instructorByIdJoinFetch = appDAO.findInstructorByIdJoinFetch(4);
		System.out.println("Instructor found: " + instructorByIdJoinFetch);
		System.out.println("The courses: " + instructorByIdJoinFetch.getCourses());
		System.out.println("Instructor Detail: " + instructorByIdJoinFetch.getInstructorDetail());
	}


	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Susan", "Public", "susan.public@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Video Games");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

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
