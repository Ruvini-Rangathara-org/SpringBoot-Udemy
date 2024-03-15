package com.example.onetoonecreate;

import com.example.onetoonecreate.dao.AppDAO;
import com.example.onetoonecreate.entity.Instructor;
import com.example.onetoonecreate.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneCreateApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneCreateApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AppDAO appDAO) {
		return (args) -> {
			System.out.println("Hello World");

			createInstructor(appDAO);
		};
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
