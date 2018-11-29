package com.giang.jobhunt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobHuntApplication {

	public static void main(String[] args) {
		System.out.println("Starting server");
		SpringApplication.run(JobHuntApplication.class, args);
		System.out.println("Finish");
	}
}
