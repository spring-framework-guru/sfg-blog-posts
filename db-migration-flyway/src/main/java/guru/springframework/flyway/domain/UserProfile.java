package guru.springframework.flyway.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String city;
    private String gender;

    public UserProfile(String name, String city, String gender) {
        this.name = name;
        this.city = city;
        this.gender=gender;
    }
}
