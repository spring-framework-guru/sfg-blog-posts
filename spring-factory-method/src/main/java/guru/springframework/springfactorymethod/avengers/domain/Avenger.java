package guru.springframework.springfactorymethod.avengers.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Avenger {

  private String name;
  private String gender;
  private Integer doj;
  private String notes;
}
