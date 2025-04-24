package hello.cluebackend.web.schedule.dto;

import hello.cluebackend.domain.schdule.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DaySchedule {
  private int dayOfWeek;
  private int period;
  private String subjectName;
  private int classRoomId;

  public DaySchedule(int dayOfWeek, int period, String subjectName, int classRoomId) {
    this.dayOfWeek = dayOfWeek;
    this.period = period;
    this.subjectName = subjectName;
    this.classRoomId = classRoomId;
  }

  public static DaySchedule fromEntity(Schedule schedule) {
    return new DaySchedule(
            schedule.getDayOfWeek(),
            schedule.getPeriod(),
            schedule.getSubjectName(),
            schedule.getClassRoomId()
    );
  }
}
