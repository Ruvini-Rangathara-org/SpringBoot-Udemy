package com.example.coredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = "com.example"
)
public class CoreDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreDemoApplication.class, args);
    }

}
