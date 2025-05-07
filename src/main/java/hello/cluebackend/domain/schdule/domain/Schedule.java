package hello.cluebackend.domain.schdule.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "day_schedule")
@Getter @Setter
public class Schedule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  private int grade;
  private int classNumber;
  private int dayOfWeek; // 1 ~ 7
  private int period;
  private String subjectName;

  public Schedule() {}

  public Schedule(int grade, int classNumber, int dayOfWeek, int period, String subjectName) {
    this.grade = grade;
    this.classNumber = classNumber;
    this.dayOfWeek = dayOfWeek;
    this.period = period;
    this.subjectName = subjectName;
  }
}