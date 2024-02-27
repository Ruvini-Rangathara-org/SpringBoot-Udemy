package com.example.deletestudentdemo;

import com.example.deletestudentdemo.dao.StudentDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeleteStudentDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeleteStudentDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {

		return runner -> {
//			deleteStudent(studentDao);
			deleteByEmail(studentDao);
		};
	}

	private void deleteByEmail(StudentDao studentDao) {
		String email  = "mary@gmail.com";
		int i = studentDao.deleteByEmail(email);
		System.out.println("Deleted student count with email : "+i);
	}

	private void deleteStudent(StudentDao studentDao) {
		studentDao.delete(3004);
		System.out.println("Deleted student with id: 3004");
	}
}
