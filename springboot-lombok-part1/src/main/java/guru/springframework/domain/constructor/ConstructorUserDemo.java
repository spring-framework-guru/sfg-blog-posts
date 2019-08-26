package guru.springframework.domain.constructor;

import lombok.*;

/*
@NoArgsConstructor annotation for generating a constructor with no parameters
*/
@NoArgsConstructor
/*
@AllArgsConstructor annotation for generating a constructor
with 1 parameter for each field
*/
@AllArgsConstructor
public class ConstructorUserDemo {
    private int userId;
    private String userName;
    private int userAge;
}
