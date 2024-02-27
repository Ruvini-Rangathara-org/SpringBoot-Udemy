package com.example.beanconfigdemo.config;

import com.example.beanconfigdemo.common.Coach;
import com.example.beanconfigdemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean(name = "aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
