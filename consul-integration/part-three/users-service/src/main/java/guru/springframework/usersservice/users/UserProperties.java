package guru.springframework.usersservice.users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("guru-user")
public class UserProperties {
    private String name = "Spring";
    private String surname = "Guru";
}