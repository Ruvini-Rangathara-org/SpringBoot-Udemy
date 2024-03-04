package com.example.deletealldemo;

import com.example.deletealldemo.dao.StudentDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeleteAllDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeleteAllDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			deleteAll(studentDao);
		};
	}

	private void deleteAll(StudentDao studentDao) {
		int i = studentDao.deleteAll();
		System.out.println("Deleted student count: " + i);
	}
}
