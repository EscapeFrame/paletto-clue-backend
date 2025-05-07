package hello.cluebackend.domain.schdule.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponse {
  private int Grade;
  private int ClassNumber;
  private int getDayOfWeek;
  private int Period;
  private String SubjectName;
}
