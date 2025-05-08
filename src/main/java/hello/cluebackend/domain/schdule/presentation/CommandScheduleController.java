package hello.cluebackend.domain.schdule.presentation;

import hello.cluebackend.domain.schdule.presentation.dto.request.UpdateScheduleRequest;
import hello.cluebackend.domain.schdule.presentation.dto.response.UpdateScheduleResponse;
import hello.cluebackend.domain.schdule.service.CommandScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://0.0.0.0:3000")
@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class CommandScheduleController {
  private final CommandScheduleService commandScheduleService;

  @PatchMapping()
  public UpdateScheduleResponse updateSchedule(@RequestBody List<UpdateScheduleRequest> updateScheduleRequestsList){
    return commandScheduleService.updateSchedule(updateScheduleRequestsList);
  }
}
