package com.example.lifecycledemo.rest;

import com.example.lifecycledemo.common.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private Coach theCoach;

    public MyController(@Qualifier("cricketCoach") Coach theCoach) {
        System.out.println("MyController: inside constructor");
        this.theCoach = theCoach;
    }


    @GetMapping("/workout")
    public String getDailyWorkout() {
        return theCoach.getDailyWorkout();
    }
}
