package com.example.onetomanyunicreate;

import com.example.onetomanyunicreate.dao.AppDAO;
import com.example.onetomanyunicreate.entity.Course;
import com.example.onetomanyunicreate.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToManyUniCreateApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyUniCreateApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AppDAO appDAO) {
		return (args) -> {
			saveCourse(appDAO);

		};
	}

	private void saveCourse(AppDAO appDAO) {
		// create a course
		Course course = new Course("Pacman - How To Score One Million Points");

		// add some reviews
		course.addReview(new Review("Great course ... loved it!"));
		course.addReview(new Review("Cool course, job well done"));
		course.addReview(new Review("What a dumb course, you are an idiot!"));

		// save the course ... and leverage the cascade all :-)
		appDAO.saveCourse(course);
		System.out.println("Saved course: " + course);
	}
}
