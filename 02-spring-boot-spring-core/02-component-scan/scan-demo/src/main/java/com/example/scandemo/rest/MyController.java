package com.example.scandemo.rest;

import com.example.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private Coach myCoach;

    @Autowired
    public MyController(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/workout")
    public String sayHello() {
        return myCoach.getDailyWorkout();
    }
}
