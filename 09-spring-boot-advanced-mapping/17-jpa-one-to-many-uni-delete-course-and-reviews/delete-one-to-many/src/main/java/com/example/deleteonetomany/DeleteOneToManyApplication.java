package com.example.deleteonetomany;

import com.example.deleteonetomany.dao.AppDAO;
import com.example.deleteonetomany.entity.Course;
import com.example.deleteonetomany.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeleteOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeleteOneToManyApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(AppDAO appDAO) {
		return (args) -> {
//			saveCourse(appDAO);
//			findCourseAndReviewsByCourseId(appDAO);

			deleteCourse(appDAO);
		};
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
