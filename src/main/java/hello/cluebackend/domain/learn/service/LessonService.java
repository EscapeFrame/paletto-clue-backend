package hello.cluebackend.domain.learn.service;

import hello.cluebackend.domain.learn.domain.Lesson;
import hello.cluebackend.domain.learn.domain.repository.LessonRepository;
import hello.cluebackend.domain.learn.presentation.dto.request.CreateLessonRequestDto;
import hello.cluebackend.domain.learn.presentation.dto.request.UpdateLessonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
  private final LessonRepository lessonRepository;

  public Lesson createLesson(CreateLessonRequestDto request) {
    Lesson lesson = new Lesson();
    lesson.setTitle(request.getTitle());
    lesson.setDescription(request.getDescription());
    lesson.setInstructor(request.getInstructor());

    return lessonRepository.save(lesson);
  }

  public List<Lesson> getAllLessons() {
    return lessonRepository.findAll();
  }

  public Lesson getLessonById(Long id) {
    return lessonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("수업을 찾을 수 없습니다."));
  }

  public Lesson updateLesson(Long id, UpdateLessonRequestDto request) {
    Lesson lesson = getLessonById(id);
    lesson.setTitle(request.getTitle());
    lesson.setDescription(request.getDescription());
    lesson.setInstructor(request.getInstructor());

    return lessonRepository.save(lesson);
  }

  public void deleteLesson(Long id) {
    Lesson lesson = getLessonById(id);
    lessonRepository.delete(lesson);
  }
}
