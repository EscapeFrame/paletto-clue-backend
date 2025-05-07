package hello.cluebackend.domain.schdule.service;

import hello.cluebackend.domain.schdule.domain.Schedule;
import hello.cluebackend.domain.schdule.domain.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandScheduleService {
  private final ScheduleRepository scheduleRepository;

  public Schedule updateSubjectName(int grade, int classNumber, int dayOfWeek, int period, String subjectName) {
    Schedule schedule = scheduleRepository
            .findByGradeAndClassNumberAndDayOfWeekAndPeriod(grade, classNumber, dayOfWeek, period)
            .orElseThrow(() -> new IllegalArgumentException("해당 조건에 맞는 시간표가 없습니다."));

    schedule.setSubjectName(subjectName);
    return scheduleRepository.save(schedule);
  }
}