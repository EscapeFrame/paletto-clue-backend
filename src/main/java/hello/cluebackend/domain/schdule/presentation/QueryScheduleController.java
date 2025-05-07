package hello.cluebackend.domain.schdule.presentation;
import hello.cluebackend.domain.schdule.service.QueryScheduleService;
import hello.cluebackend.domain.schdule.presentation.dto.DaySchedule;
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
  @GetMapping(params = {"grade", "classNumber"})
  public List<DaySchedule> getWeeklySchedule(
          @RequestParam int grade,
          @RequestParam int classNumber
  ) {
    return scheduleService.getWeeklySchedule(grade, classNumber);
  }

  // 하루 시간표 반환
  @GetMapping(params = {"grade", "classNumber", "dayOfWeek"})
  public List<DaySchedule> getDailySchedule(
          @RequestParam int grade,
          @RequestParam int classNumber,
          @RequestParam int dayOfWeek
  ) {
    return scheduleService.getDailySchedule(grade, classNumber, dayOfWeek);
  }
}