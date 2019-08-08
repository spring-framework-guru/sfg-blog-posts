package guru.springframework.gradlelombok;

import lombok.Data;

@Data
public class Job {
    private final String job;
    private String position;
    private double salary;
}
