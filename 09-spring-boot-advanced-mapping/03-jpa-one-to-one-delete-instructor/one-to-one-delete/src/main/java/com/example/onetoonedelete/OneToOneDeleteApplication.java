package com.example.onetoonedelete;

import com.example.onetoonedelete.dao.AppDAO;
import com.example.onetoonedelete.entity.Instructor;
import com.example.onetoonedelete.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneDeleteApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneDeleteApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AppDAO appDAO) {
		return (args) -> {
			System.out.println("Hello World");

//			createInstructor(appDAO);
//			findInstructor(appDAO);
			deleteInstructor(appDAO);

		};
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

		appDAO.save(tempInstructor);
		System.out.println("Instructor saved: " + tempInstructor);

	}
}
