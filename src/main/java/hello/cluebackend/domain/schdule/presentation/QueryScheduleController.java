package hello.cluebackend.domain.schdule.presentation;
import hello.cluebackend.domain.schdule.service.QueryScheduleService;
import hello.cluebackend.domain.schdule.presentation.dto.response.GetScheduleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://0.0.0.0:3000")
@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class QueryScheduleController {
  private final QueryScheduleService scheduleService;

  // 일주일 시간표 반환
  @GetMapping("/week")
  public List<GetScheduleResponse> getWeeklySchedule(
          @RequestParam Integer classNumber
  ) {
    return scheduleService.getWeeklySchedule(classNumber);
  }

  // 하루 시간표 반환
  @GetMapping("/day")
  public List<GetScheduleResponse> getDailySchedule(
          @RequestParam Integer classNumber,
          @RequestParam Integer dayOfWeek
  ) {
    return scheduleService.getDailySchedule(classNumber, dayOfWeek);
  }
}