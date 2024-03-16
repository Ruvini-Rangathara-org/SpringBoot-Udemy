package com.example.jpabideletedemo;

import com.example.jpabideletedemo.dao.AppDAO;
import com.example.jpabideletedemo.entity.Instructor;
import com.example.jpabideletedemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaBiDeleteDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaBiDeleteDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AppDAO appDAO) {
		return (args) -> {
			System.out.println("Hello World");

//			deleteInstructor(appDAO);
//			createInstructor(appDAO);
//			findInstructor(appDAO);

			findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);

		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		appDAO.deleteInstructorDetailById(3);
		System.out.println("Instructor detail deleted");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(3);
		System.out.println("Instructor detail found: " + instructorDetail);
		System.out.println("Instructor found: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		appDAO.deleteById(1);
		System.out.println("Instructor deleted");
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
