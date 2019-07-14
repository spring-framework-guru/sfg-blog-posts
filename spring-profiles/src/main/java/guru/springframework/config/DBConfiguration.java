package guru.springframework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {
    private String driverClassName;
    private String url;
    private String userName;
    private String password;

    @Profile("dev")
    @Bean
    public String devDBCcnnection() {
        System.out.println("DB Connection for Dev");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection for Dev";
    }

    @Profile("test")
    @Bean
    public String devTestCcnnection() {
        System.out.println("DB Connection for Test");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection for Test";
    }

    @Profile("prod")
    @Bean
    public String devProdCcnnection() {
        System.out.println("DB Connection for Prod");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection for Prod";
    }

}
