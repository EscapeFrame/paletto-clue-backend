package hello.cluebackend.domain.learn.presentation.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateLessonRequestDto {
  private String title;
  private String description;
  private String instructor;
}
