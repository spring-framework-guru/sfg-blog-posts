package guru.springframework.springrestexception.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_types")
@Data
@NoArgsConstructor
public class PetType extends BaseEntity {

  @Column(name = "name")
  @NotEmpty
  private String name;
}
