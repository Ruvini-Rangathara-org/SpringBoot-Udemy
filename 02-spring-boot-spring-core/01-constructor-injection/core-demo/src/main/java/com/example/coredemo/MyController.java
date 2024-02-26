package com.example.coredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private Coach coach;

    @Autowired
    public MyController(Coach theCoach) {
        coach = theCoach;
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
