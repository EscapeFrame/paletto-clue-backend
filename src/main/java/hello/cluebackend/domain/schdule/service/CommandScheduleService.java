package hello.cluebackend.domain.schdule.service;

import hello.cluebackend.domain.schdule.domain.Schedule;
import hello.cluebackend.domain.schdule.domain.repository.ScheduleRepository;
import hello.cluebackend.domain.schdule.presentation.dto.request.UpdateScheduleRequest;
import hello.cluebackend.domain.schdule.presentation.dto.response.UpdateScheduleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandScheduleService {
  private final ScheduleRepository scheduleRepository;


  public UpdateScheduleResponse updateSchedule(List<UpdateScheduleRequest> updateScheduleRequestsList) {
    for (UpdateScheduleRequest req : updateScheduleRequestsList) {
      Schedule schedule  = scheduleRepository.findById(req.getId())
              .orElseThrow(() -> new IllegalArgumentException("해당 ID의 시간표가 없습니다: " + req.getId()));

      schedule.setDayOfWeek(req.getDayOfWeek());
      schedule.setPeriod(req.getPeriod());
      schedule.setSubjectName(req.getSubjectName());

      scheduleRepository.save(schedule);
    }
    return new UpdateScheduleResponse(true);
  }
}
