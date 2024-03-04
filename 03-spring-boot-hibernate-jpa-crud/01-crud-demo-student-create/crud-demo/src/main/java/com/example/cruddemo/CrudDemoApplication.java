package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDao;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			createStudent(studentDao);
			createMultipleStudents(studentDao);
		};
	}

	private void createMultipleStudents(StudentDao studentDao) {
		//query for start auto increment from 3000
//		alter table student_tracker.student auto_increment=3000;

		Student student1 = new Student("Jane", "Doe", "jane@gmail.com");
		Student student2 = new Student("Mary", "Doe", "mary@gmail.com");
		Student student3 = new Student("Tom", "Doe", "tom@gmail.com");

		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);
	}

	private void createStudent(StudentDao studentDao) {
		Student student = new Student();
		student.setFirstName("John");
		student.setLastName("Doe");
		student.setEmail("john@gmail.com");

		studentDao.save(student);

		System.out.println("Student saved: " + student.toString());
	}
}
