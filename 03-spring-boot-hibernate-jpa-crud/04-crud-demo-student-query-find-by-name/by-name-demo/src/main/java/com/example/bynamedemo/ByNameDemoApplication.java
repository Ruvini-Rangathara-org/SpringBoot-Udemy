package com.example.bynamedemo;

import com.example.bynamedemo.dao.StudentDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ByNameDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ByNameDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            findByLastName(studentDao);
        };

	}

	private void findByLastName(StudentDao studentDao) {
		System.out.println("Retrieving students by last name ...");
		studentDao.findAllByLastName("Rangathara").forEach(System.out::println);
	}
}
