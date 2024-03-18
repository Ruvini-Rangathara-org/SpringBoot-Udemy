package com.example.eagerfinddemo;

import com.example.eagerfinddemo.dao.AppDAO;
import com.example.eagerfinddemo.entity.Course;
import com.example.eagerfinddemo.entity.Instructor;
import com.example.eagerfinddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EagerFindDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EagerFindDemoApplication.class, args);
	}



	@Bean
	public CommandLineRunner demo(AppDAO appDAO) {
		return (args) -> {
			System.out.println("Hello World");
//			createInstructorWithCourses(appDAO);

			findInstructorWithCourses(appDAO);
		};
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = appDAO.findById(4);
		System.out.println("Instructor found: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());
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


	private void findInstructorDetail(AppDAO appDAO) {
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(3);
		System.out.println("Instructor detail found: " + instructorDetail);
		System.out.println("Instructor found: " + instructorDetail.getInstructor());
	}

	private void findInstructor(AppDAO appDAO) {
		Instructor instructor = appDAO.findById(1);
		System.out.println("Instructor found: " + instructor);
		System.out.println("Instructor detail found: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@gmail.com");

		InstructorDetail detail = new InstructorDetail(
				"http://www.luv2code.com/youtube",
				"Guitar");

		tempInstructor.setInstructorDetail(detail);
		detail.setInstructor(tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Instructor saved: " + tempInstructor);

	}
}
