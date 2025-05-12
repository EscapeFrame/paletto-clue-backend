package hello.cluebackend.domain.schdule.service;

import hello.cluebackend.domain.schdule.domain.Schedule;
import hello.cluebackend.domain.schdule.domain.repository.ScheduleRepository;
import hello.cluebackend.domain.schdule.presentation.dto.response.UpdateScheduleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandScheduleService {
  private final ScheduleRepository scheduleRepository;

  public Schedule updateSubjectName(UpdateScheduleResponse response) {
    Schedule schedule = scheduleRepository
            .findByClassNumberAndDayOfWeekAndPeriod(
                    response.getClassNumber(),
                    response.getDayOfWeek(),
                    response.getPeriod()
            )
            .orElseThrow(() -> new IllegalArgumentException("해당 조건에 맞는 시간표가 없습니다."));

    schedule.setSubjectName(response.getSubjectName());
    schedule.setTeacherName(response.getTeacherName());

    scheduleRepository.save(schedule);

    return schedule;
  }
}