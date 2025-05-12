package hello.cluebackend.domain.schdule.presentation.dto.response;

import hello.cluebackend.domain.schdule.domain.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateScheduleResponse {
  private Integer classNumber;
  private Integer dayOfWeek;
  private Integer period;
  private String subjectName;
  private String teacherName;

  public UpdateScheduleResponse(Schedule schedule) {
    this.classNumber = schedule.getClassNumber();
    this.dayOfWeek = schedule.getDayOfWeek();
    this.period = schedule.getPeriod();
    this.subjectName = schedule.getSubjectName();
    this.teacherName = schedule.getTeacherName();
  }

  public static UpdateScheduleResponse from(Schedule schedule) {
    return new UpdateScheduleResponse(schedule);
  }
}