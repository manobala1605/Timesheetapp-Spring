package com.timesheetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimeSheetAppSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeSheetAppSpringApplication.class, args);
		System.out.println("Starting Time Sheet App...");
	}

}
