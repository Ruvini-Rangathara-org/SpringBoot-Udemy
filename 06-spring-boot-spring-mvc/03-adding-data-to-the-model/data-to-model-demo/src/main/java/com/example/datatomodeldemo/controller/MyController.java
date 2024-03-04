package com.example.datatomodeldemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/processForm2")
    public String processForm2(HttpServletRequest request, Model model) {

        String name = request.getParameter("name");
        name = name.toUpperCase();
        String result = "Yo! " + name;
        model.addAttribute("message", result);
        return "process2";
    }

}
