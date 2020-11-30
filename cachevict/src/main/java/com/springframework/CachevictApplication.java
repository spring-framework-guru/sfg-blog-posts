package com.springframework;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CachevictApplication {
    public static void main(String[] args) {
       // SpringApplication.run(CachevictApplication.class,args);

        SpringApplication application = new SpringApplication(CachevictApplication.class);
        // ... customize application settings here
        application.run(args);


    }
}
