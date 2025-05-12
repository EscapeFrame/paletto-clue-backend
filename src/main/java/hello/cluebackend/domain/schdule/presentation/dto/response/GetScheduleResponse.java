package hello.cluebackend.domain.schdule.presentation.dto.response;

import hello.cluebackend.domain.schdule.domain.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GetScheduleResponse {
  private Integer dayOfWeek;
  private Integer period;
  private String subjectName;
  private String teacherName;

  public GetScheduleResponse(Integer dayOfWeek, Integer period, String subjectName, String teacherName) {
    this.dayOfWeek = dayOfWeek;
    this.period = period;
    this.subjectName = subjectName;
    this.teacherName = teacherName;
  }

  public static GetScheduleResponse fromEntity(Schedule schedule) {
    return new GetScheduleResponse(
            schedule.getDayOfWeek(),
            schedule.getPeriod(),
            schedule.getSubjectName(),
            schedule.getTeacherName()
    );
  }
}