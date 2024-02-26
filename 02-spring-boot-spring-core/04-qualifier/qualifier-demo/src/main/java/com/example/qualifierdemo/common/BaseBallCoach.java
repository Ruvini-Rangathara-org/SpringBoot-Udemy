package com.example.qualifierdemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Base Ball Coach : Spend 30 minutes on batting practice";
    }
}
