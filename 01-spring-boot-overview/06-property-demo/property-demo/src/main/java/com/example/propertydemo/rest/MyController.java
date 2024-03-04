package com.example.propertydemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Value("${coach.name}")
    private String myName;

    @Value("${team.name}")
    private String myTeam;

    @GetMapping("/myinfo")
    public String getMyInfo() {
        return "Name: " + myName + ", Team: " + myTeam;
    }
}
