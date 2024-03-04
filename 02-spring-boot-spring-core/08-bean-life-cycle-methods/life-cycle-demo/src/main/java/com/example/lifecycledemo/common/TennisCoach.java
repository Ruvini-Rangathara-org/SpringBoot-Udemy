package com.example.lifecycledemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println("Tennis Coach: Inside no-arg constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Tennis Coach : Practice your backhand volley";
    }
}
