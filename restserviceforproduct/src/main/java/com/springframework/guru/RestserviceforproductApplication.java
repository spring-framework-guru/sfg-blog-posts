package com.springframework.guru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RestserviceforproductApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestserviceforproductApplication.class, args);
	}

}
