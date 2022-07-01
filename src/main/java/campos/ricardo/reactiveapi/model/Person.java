package campos.ricardo.reactiveapi.model;

import campos.ricardo.reactiveapi.vo.BaseResponse;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Entity(name = "person")
@Table
public class Person implements BaseResponse {

  @Id
  @GeneratedValue
  public Long id;

  @Column
  public String firstName;

  @Column
  public String lastName;

  @Column
  public LocalDate birthDate;
}
