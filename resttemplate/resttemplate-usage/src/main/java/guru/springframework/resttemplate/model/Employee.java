package guru.springframework.resttemplate.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {

  private long id;
  private String firstName;
  private String lastName;
  private long yearlyIncome;

}