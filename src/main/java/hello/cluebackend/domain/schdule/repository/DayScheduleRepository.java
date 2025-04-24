package hello.cluebackend.domain.schdule.repository;

import hello.cluebackend.domain.schdule.entity.Schedule;
import hello.cluebackend.web.schedule.dto.DaySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayScheduleRepository extends JpaRepository<Schedule, Long> {
  List<Schedule> findByGradeAndClassNumberAndDayOfWeek(int grade, int classNumber, int dayOfWeek);

  List<Schedule> findByGradeAndClassNumber(int grade, int classNumber);
}
