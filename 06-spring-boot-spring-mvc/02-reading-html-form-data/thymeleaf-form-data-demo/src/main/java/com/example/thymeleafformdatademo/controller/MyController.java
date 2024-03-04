package com.example.thymeleafformdatademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class MyController {

    @GetMapping("/show")
    public String showForm() {
        return "show-form";
    }

    @GetMapping("/process")
    public String processForm() {
        return "process-form";
    }

}
