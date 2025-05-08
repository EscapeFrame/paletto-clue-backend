package hello.cluebackend.domain.schdule.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "day_schedule")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  //학년 반  ex ) 1학년 1반 -> 11
  @Column(nullable = false)
  private int classNumber;

  @Column(nullable = false)
  private int dayOfWeek; // 1 ~ 7

  @Column(nullable = false)
  private int period;

  @Setter
  @Column(nullable = false)
  private String subjectName;

  @Setter
  @Column(nullable = false)
  private String teacherName;

  public Schedule(Integer classNumber, Integer dayOfWeek, Integer period, String subjectName, String teacherName) {
    this.classNumber = classNumber;
    this.dayOfWeek = dayOfWeek;
    this.period = period;
    this.subjectName = subjectName;
    this.teacherName = teacherName;
  }

  public static Schedule of(Integer classNumber, Integer dayOfWeek, Integer period, String subjectName, String teacherName) {
    return new Schedule(classNumber, dayOfWeek, period, subjectName,teacherName);
  }
}