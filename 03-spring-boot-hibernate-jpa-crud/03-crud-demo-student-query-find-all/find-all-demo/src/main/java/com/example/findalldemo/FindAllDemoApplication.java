package com.example.findalldemo;

import com.example.findalldemo.dao.StudentDao;
import com.example.findalldemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FindAllDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindAllDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDAO) {

		return runner -> {
			findAllStudents(studentDAO);
		};
	}

	private void findAllStudents(StudentDao studentDAO) {
		System.out.println("Retrieving all students ...");
		List<Student> all = studentDAO.findAll();

		//using lambda expression
		all.forEach(student -> System.out.println(student));

		//using method reference
		all.forEach(System.out::println);
	}
}
