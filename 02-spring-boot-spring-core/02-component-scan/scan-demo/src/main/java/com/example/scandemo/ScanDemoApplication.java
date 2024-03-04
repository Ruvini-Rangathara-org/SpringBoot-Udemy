package com.example.scandemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.example.scandemo",
							"com.example.util"}
)
public class ScanDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScanDemoApplication.class, args);
	}

}
