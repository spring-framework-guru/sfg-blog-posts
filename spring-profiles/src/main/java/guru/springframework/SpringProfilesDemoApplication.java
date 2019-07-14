package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringProfilesDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProfilesDemoApplication.class, args);


    }

}
