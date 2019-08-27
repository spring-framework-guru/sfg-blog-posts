package guru.springframework.domain.builder;

import lombok.*;

@Data
/*
@Builder annotation creates instances of our class
*/
@Builder(toBuilder = true)
public class BuilderUserDemo {
    private int userId;
    private String userName;
    private int userAge;
}
