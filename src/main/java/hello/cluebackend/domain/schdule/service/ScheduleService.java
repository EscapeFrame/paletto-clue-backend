package hello.cluebackend.domain.schdule.service;

import hello.cluebackend.domain.schdule.entity.Schedule;
import hello.cluebackend.domain.schdule.repository.DayScheduleRepository;
import hello.cluebackend.web.schedule.dto.DaySchedule;
import hello.cluebackend.web.schedule.dto.RequestSchedule;
import hello.cluebackend.web.schedule.dto.ResponseSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

  private final DayScheduleRepository repository;

  public List<DaySchedule> getDailySchedule(int grade, int classNumber, int dayOfWeek) {
    return repository.findByGradeAndClassNumberAndDayOfWeek(grade, classNumber, dayOfWeek)
            .stream()
            .map(DaySchedule::fromEntity)
            .collect(Collectors.toList());
  }

  public List<DaySchedule> getWeeklySchedule(int grade, int classNumber) {
    return repository.findByGradeAndClassNumber(grade, classNumber)
            .stream()
            .map(DaySchedule::fromEntity)
            .collect(Collectors.toList());
  }

  public ResponseSchedule createSchedule(RequestSchedule request) {
    Schedule schedule = new Schedule( 1, 1, request.getDayOfWeek(), request.getPeriod(), request.getSubjectName(), 1 );
    Schedule savedSchedule = repository.save(schedule);
    return new ResponseSchedule(true);
  }

  /* 과목 수정
  public void updateSchedule(Long scheduleId, DaySchedule dto, UserInfo user) {
    DaySchedule schedule = repository.findById(scheduleId)
            .orElseThrow(() -> new RuntimeException("해당 시간표가 존재하지 않음"));

    if (user.getGrade() != schedule.getGrade() || user.getClassNumber() != schedule.getClassNumber()) {
      throw new RuntimeException("본인의 반만 수정할 수 있습니다.");
    }

    schedule.setSubjectName(dto.getSubjectName());
    schedule.setPeriod(dto.getPeriod());
    schedule.setClassRoomId(dto.getClassRoomId());
    repository.save(schedule);
  }
   */
}