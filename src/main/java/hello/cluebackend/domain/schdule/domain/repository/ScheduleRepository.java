package hello.cluebackend.domain.schdule.domain.repository;

import hello.cluebackend.domain.schdule.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
  List<Schedule> findByClassNumberAndDayOfWeek(int classNumber, int dayOfWeek);
  List<Schedule> findByClassNumber(int classNumber);

  Optional<Schedule> findByClassNumberAndDayOfWeekAndPeriod(
          Integer classNumber, Integer dayOfWeek, Integer period);

  List<Schedule> findByClassNumber(Integer classNumber);
}
