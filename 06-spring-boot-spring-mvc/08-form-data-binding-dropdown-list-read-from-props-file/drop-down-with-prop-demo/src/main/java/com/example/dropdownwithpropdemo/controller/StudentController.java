package com.example.dropdownwithpropdemo.controller;

import com.example.dropdownwithpropdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showForm")
    public String showForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countries", countries);
        return "student-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println("student: " + student.getFirstName() + " " + student.getLastName() + " " + student.getCountry() );

        return "student-confirmation";
    }
}
