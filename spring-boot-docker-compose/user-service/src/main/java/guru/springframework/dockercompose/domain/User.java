package guru.springframework.dockercompose.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * define an document
 */
@Document(value = "User")
/**
 * Lombok annotation for generating getters and setters
 */
@Getter
@Setter
/**
 * Lombok annotation for generating default constructor
 */
@AllArgsConstructor
/**
 * Lombok annotation for generating parameterized constructor
 */
@NoArgsConstructor
public class User {

    /**
     * @Id annotation makes id variable as Primary key
     */
    @Id
    private int id;
    private String name;
}
