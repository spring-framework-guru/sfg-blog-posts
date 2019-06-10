package guru.springframework.ehcache.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Student {

  private final long id;
  private final String firstName;
  private final String lastName;
  private final String courseOfStudies;

}
