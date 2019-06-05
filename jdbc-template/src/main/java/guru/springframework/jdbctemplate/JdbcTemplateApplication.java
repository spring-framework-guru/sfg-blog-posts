package guru.springframework.jdbctemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcTemplateApplication {

  public static void main(String[] args) {
    SpringApplication.run(JdbcTemplateApplication.class, args);
    System.out.println("Hello JdbcTemplate");
  }

}
