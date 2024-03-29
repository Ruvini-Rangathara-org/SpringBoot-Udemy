package com.example.dropdowndemo.controller;

import com.example.dropdowndemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showForm")
    public String showForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);
        return "student-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println("student: " + student.getFirstName() + " " + student.getLastName() + " " + student.getCountry() );

        return "student-confirmation";
    }
}
