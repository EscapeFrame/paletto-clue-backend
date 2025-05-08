package hello.cluebackend.domain.schdule.service;

import hello.cluebackend.domain.schdule.domain.repository.ScheduleRepository;
import hello.cluebackend.domain.schdule.presentation.dto.DaySchedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class QueryScheduleService {
  private final ScheduleRepository repository;

  // 일 단위 시간표 반환
  public List<DaySchedule> getDailySchedule(int grade, int classNumber, int dayOfWeek) {
    return repository.findByGradeAndClassNumberAndDayOfWeek(grade, classNumber, dayOfWeek)
            .stream()
            .map(DaySchedule::fromEntity)
            .collect(Collectors.toList());
  }

  // 주 단위 시간표 반환
  public List<DaySchedule> getWeeklySchedule(int grade, int classNumber) {
    return repository.findByGradeAndClassNumber(grade, classNumber)
            .stream()
            .map(DaySchedule::fromEntity)
            .collect(Collectors.toList());
  }
}