package hello.cluebackend.domain.learn.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Class {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private String instructor;

  @OneToMany(mappedBy = "lesson")
  private List<Student> students;
}
