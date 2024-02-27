package com.example.lifecycledemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("Cricket Coach: Inside no-arg constructor");
    }


    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("Cricket Coach: Inside doMyStartupStuff : "+getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("Cricket Coach: Inside doMyCleanupStuff : "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach: Practice fast bowling for 15 minutes";
    }
}
