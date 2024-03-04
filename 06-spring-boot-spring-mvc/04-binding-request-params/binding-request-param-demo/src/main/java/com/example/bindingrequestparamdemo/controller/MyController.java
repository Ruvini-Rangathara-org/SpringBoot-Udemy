package com.example.bindingrequestparamdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class MyController {

    @GetMapping("/show")
    public String showForm() {
        return "show-form";
    }

    @GetMapping("/process")
    public String processForm2(@RequestParam("name") String name, Model model) {

        name = name.toUpperCase();
        String result = "Yo! " + name;
        model.addAttribute("message", result);
        return "process2";
    }

}
