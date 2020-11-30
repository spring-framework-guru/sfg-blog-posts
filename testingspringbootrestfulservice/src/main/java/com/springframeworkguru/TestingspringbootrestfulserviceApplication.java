package com.springframeworkguru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingspringbootrestfulserviceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TestingspringbootrestfulserviceApplication.class, args);

		SpringApplication application = new SpringApplication(TestingspringbootrestfulserviceApplication.class);
		// ... customize application settings here
		application.run(args);
	}

}
