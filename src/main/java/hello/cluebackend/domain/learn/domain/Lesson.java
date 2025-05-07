package hello.cluebackend.domain.learn.domain;

import hello.cluebackend.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Lesson {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private String instructor;

  @OneToMany(mappedBy = "lesson")
  private List<User> students;
}
