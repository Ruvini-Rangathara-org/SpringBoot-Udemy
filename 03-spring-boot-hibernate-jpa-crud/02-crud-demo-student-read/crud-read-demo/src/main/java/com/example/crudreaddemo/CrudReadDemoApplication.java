package com.example.crudreaddemo;

import com.example.crudreaddemo.dao.StudentDao;
import com.example.crudreaddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudReadDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudReadDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			readStudent(studentDao);

		};
	}

	private void readStudent(StudentDao studentDao) {
		Student student = new Student("Ruvini", "Rangathara", "ruvini@gmail.com");
		studentDao.save(student);

		int id = student.getId();
		System.out.println("Saved student. Generated id: " + id);

		Student myStudent = studentDao.findById(id);
		System.out.println("Found the student: " + myStudent);

	}

}
