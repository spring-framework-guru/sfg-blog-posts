package guru.springframework.jdbctemplate.employee;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class Employee {

  private long id;
  private String firstName;
  private String lastName;
  private long yearlyIncome;

  public Map<String, Object> toMap() {
    Map<String, Object> values = new HashMap<>();
    values.put("first_name", firstName);
    values.put("last_name", lastName);
    values.put("yearly_income", yearlyIncome);

    return values;
  }

}