package com.example.beanconfigdemo.rest;

import com.example.beanconfigdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private Coach coach;

    @Autowired
    public MyController( @Qualifier("aquatic") Coach coach) {
        this.coach = coach;
        System.out.println("MyController: inside constructor : "+getClass().getSimpleName());
    }


    @GetMapping("/workout")
    public String getWorkout() {
        return coach.getDailyWorkout();
    }

}
