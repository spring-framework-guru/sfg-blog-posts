package guru.springframework.domain.builder;

import lombok.*;

@Data
/*
@Builder annotation generates boilerplate code
to create instances of our class using the Builder pattern
*/
@Builder(toBuilder = true)
public class BuilderUserDemo {
    private int userId;
    private String userName;
    private int userAge;
}
