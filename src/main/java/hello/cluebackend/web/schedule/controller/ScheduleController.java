package hello.cluebackend.web.schedule.controller;
import hello.cluebackend.domain.schdule.service.ScheduleService;
import hello.cluebackend.web.schedule.dto.DaySchedule;
import hello.cluebackend.web.schedule.dto.RequestSchedule;
import hello.cluebackend.web.schedule.dto.ResponseSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://0.0.0.0:3000")
@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {
  private final ScheduleService scheduleService;
  //private final JwtService jwtService;

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

  @PostMapping()
  public ResponseSchedule getDailySchedule(@RequestBody RequestSchedule request) {
    return scheduleService.createSchedule(request);
  }



  /*
  @PutMapping("/{scheduleId}")
  public void updateSchedule(
          @PathVariable Long scheduleId,
          @RequestBody DaySchedule dto,
          HttpServletRequest request
  ) {
    UserInfo user = jwtService.extractUserInfo(request); // 학생의 반 정보 파싱
    scheduleService.updateSchedule(scheduleId, dto, user);
  }*/ //Oauth 완료시 개발
}