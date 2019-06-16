package guru.springframework.springrestexception.domain.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet extends BaseEntity {

  @Column(name = "name", unique = true)
  @NotEmpty
  private String name;

  @Column(name = "birth_date")
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthDate;

  @ManyToOne
  @JoinColumn(name = "type_id")
  private PetType type;
}
