package hello.cluebackend.domain.schdule.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateScheduleRequest {
  private int grade;
  private int classNumber;
  private int dayOfWeek;
  private int period;
  private String subjectName;
}