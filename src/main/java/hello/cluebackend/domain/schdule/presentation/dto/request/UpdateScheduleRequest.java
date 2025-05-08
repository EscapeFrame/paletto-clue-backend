package hello.cluebackend.domain.schdule.presentation.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateScheduleRequest {
  @NotNull(message = "반은 필수 입력값입니다")
  private Integer classNumber;

  @NotBlank(message = "요일은 필수 입력값입니다")
  private Integer dayOfWeek;

  @NotNull(message = "교시는 필수 입력값입니다")
  @Min(value = 1, message = "교시는 1 이상이어야 합니다")
  @Max(value = 7, message = "교시는 7 이하여야 합니다")
  private Integer period;

  @NotBlank(message = "과목명은 필수 입력값입니다")
  private String subjectName;

  private String teacherName;
}