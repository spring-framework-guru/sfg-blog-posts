package guru.springframework.gradlelombok.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Person {
    private String firstname;
    private String surname;
    private int age;
    private int height;
    private Job job;
}