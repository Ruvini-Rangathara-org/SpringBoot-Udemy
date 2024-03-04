package com.example.restallstudentrefacteddemo.rest;

import com.example.restallstudentrefacteddemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = List.of(
                new Student(1, "Poornima", "Patel"),
                new Student(2, "Mario", "Rossi"),
                new Student(3, "Mary", "Smith")
        );
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

}
