package hello.cluebackend.domain.schdule.presentation;

import hello.cluebackend.domain.schdule.domain.Schedule;
import hello.cluebackend.domain.schdule.presentation.dto.request.UpdateScheduleRequest;
import hello.cluebackend.domain.schdule.service.CommandScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://0.0.0.0:3000")
@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class CommandScheduleController {
  private final CommandScheduleService commandScheduleService;

  @PutMapping("/update-subject")
  public ResponseEntity<Schedule> updateSubjectName(@RequestBody UpdateScheduleRequest request) {
    Schedule updated = commandScheduleService.updateSubjectName(
            request.getGrade(),
            request.getClassNumber(),
            request.getDayOfWeek(),
            request.getPeriod(),
            request.getSubjectName()
    );
    return ResponseEntity.ok(updated);
  }
}