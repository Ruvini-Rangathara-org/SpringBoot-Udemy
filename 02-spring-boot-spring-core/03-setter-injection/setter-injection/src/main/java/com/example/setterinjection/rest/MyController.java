package com.example.setterinjection.rest;

import com.example.setterinjection.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private Coach myCoach;

    @Autowired
    public void setMyCoach(Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
