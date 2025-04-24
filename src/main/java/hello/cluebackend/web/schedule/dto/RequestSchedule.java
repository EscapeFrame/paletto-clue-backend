package hello.cluebackend.web.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestSchedule {
  private int dayOfWeek;
  private int period;
  private String subjectName;
}
