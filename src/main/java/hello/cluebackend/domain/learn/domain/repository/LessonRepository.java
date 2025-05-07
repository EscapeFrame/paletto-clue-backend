package hello.cluebackend.domain.learn.domain.repository;

import hello.cluebackend.domain.learn.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
