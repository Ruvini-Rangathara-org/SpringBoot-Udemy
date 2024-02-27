package com.example.reststudentlistdemo.rest;

import com.example.reststudentlistdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("students")
    public List<Student> getAllStudents() {
        return List.of(
                new Student(1, "John", "Doe"),
                new Student(2, "Jane", "Doe"),
                new Student(3, "Mary", "Smith")
        );
    }
}
