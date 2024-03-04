package com.example.beanscopedemo.rest;

import com.example.beanscopedemo.common.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private Coach coach;
    private Coach coach2;

    public MyController(@Qualifier("tennisCoach") Coach coach, @Qualifier("tennisCoach") Coach coach2) {
        System.out.println("MyController: Inside constructor");
        this.coach = coach;
        this.coach2 = coach2;
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Check coach == coach2 : " + (coach == coach2);
    }

}
