package hello.cluebackend.domain.schdule.service;

import hello.cluebackend.domain.schdule.domain.repository.ScheduleRepository;
import hello.cluebackend.domain.schdule.presentation.dto.response.GetScheduleResponse;
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

  // 주 단위 시간표 반환
  public List<GetScheduleResponse> getWeeklySchedule(Integer classNumber) {
    return repository.findByClassNumber(classNumber)
            .stream()
            .map(GetScheduleResponse::fromEntity)
            .collect(Collectors.toList());
  }

  // 일 단위 시간표 반환
  public List<GetScheduleResponse> getDailySchedule(Integer classNumber, Integer dayOfWeek) {
    return repository.findByClassNumberAndDayOfWeek(classNumber, dayOfWeek)
            .stream()
            .map(GetScheduleResponse::fromEntity)
            .collect(Collectors.toList());
  }
}