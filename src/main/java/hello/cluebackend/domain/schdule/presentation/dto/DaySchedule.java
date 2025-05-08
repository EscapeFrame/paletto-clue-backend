package hello.cluebackend.domain.schdule.presentation.dto;

import hello.cluebackend.domain.schdule.domain.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DaySchedule {
  private int dayOfWeek;
  private int period;
  private String subjectName;

  public DaySchedule(int dayOfWeek, int period, String subjectName) {
    this.dayOfWeek = dayOfWeek;
    this.period = period;
    this.subjectName = subjectName;
  }

  public static DaySchedule fromEntity(Schedule schedule) {
    return new DaySchedule(
            schedule.getDayOfWeek(),
            schedule.getPeriod(),
            schedule.getSubjectName()
    );
  }
}
