package hello.cluebackend.domain.schdule.domain.repository;

import hello.cluebackend.domain.schdule.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
  List<Schedule> findByGradeAndClassNumberAndDayOfWeek(int grade, int classNumber, int dayOfWeek);
  List<Schedule> findByGradeAndClassNumber(int grade, int classNumber);

  Optional<Schedule> findByGradeAndClassNumberAndDayOfWeekAndPeriod(int grade, int classNumber, int dayOfWeek, int period);
}
