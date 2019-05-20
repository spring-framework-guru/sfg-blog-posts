package guru.springframework.springfactorymethod.avengers.domain;

import lombok.Value;

@Value
public class Avenger {

  private String name;
  private String gender;
  private Integer doj;
  private String notes;
}
