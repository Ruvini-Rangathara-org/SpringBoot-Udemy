package com.example.tableautodemo;

import com.example.tableautodemo.dao.StudentDao;
import com.example.tableautodemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TableAutoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TableAutoDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			createStudent(studentDao);
		};
	}

	private void createStudent(StudentDao studentDao) {
		studentDao.save(new Student("John1", "Doe", "john@gmail.com"));
		studentDao.save(new Student("John2", "Doe", "john@gmail.com"));
		studentDao.save(new Student("John3", "Doe", "john@gmail.com"));

		System.out.println("All students save " );
	}
}
