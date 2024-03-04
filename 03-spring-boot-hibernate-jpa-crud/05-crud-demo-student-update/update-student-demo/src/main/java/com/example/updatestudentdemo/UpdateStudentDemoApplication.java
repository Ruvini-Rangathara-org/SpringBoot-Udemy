package com.example.updatestudentdemo;

import com.example.updatestudentdemo.dao.StudentDao;
import com.example.updatestudentdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.plaf.SeparatorUI;

@SpringBootApplication
public class UpdateStudentDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpdateStudentDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			updateStudent(studentDao);
		};
	}

	private void updateStudent(StudentDao studentDao) {
		// retrieve student based on the id: primary key
		int studentId = 3003;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDao.findById(studentId);
		System.out.println("Student before update : " + myStudent);

		// change first name to "John1"
		myStudent.setFirstName("John1");

		// update the student
		studentDao.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}
}
