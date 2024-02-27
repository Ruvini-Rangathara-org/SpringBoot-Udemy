package com.example.beanscopedemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("Cricket Coach: Inside no-arg constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach: Practice fast bowling for 15 minutes";
    }
}
