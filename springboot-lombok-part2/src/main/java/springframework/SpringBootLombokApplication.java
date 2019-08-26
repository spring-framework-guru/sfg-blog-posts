package springframework;

import guru.springframework.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBootLombokApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootLombokApplication.class, args);
    }
}
