package com.example.lazydemo.rest;

import com.example.lazydemo.common.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private Coach coach;

    public MyController(@Qualifier("tennisCoach") Coach coach) {
        System.out.println("MyController: Inside constructor");
        this.coach = coach;
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}
