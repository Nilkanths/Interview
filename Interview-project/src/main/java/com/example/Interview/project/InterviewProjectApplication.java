package com.example.Interview.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.Interview.controller, "+"com.example.Interview.model"+"com.example.Interview.service")
public class InterviewProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewProjectApplication.class, args);
	  System.out.println("hii");
	}

}
