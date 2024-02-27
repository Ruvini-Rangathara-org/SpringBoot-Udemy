package com.example.beanconfigdemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {
    public BaseBallCoach() {
        System.out.println("BaseBallCoach: inside no-arg constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Base Ball Coach : Spend 30 minutes on batting practice";
    }
}
