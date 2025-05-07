package hello.cluebackend.domain.learn.presentation;

import hello.cluebackend.domain.learn.domain.Lesson;
import hello.cluebackend.domain.learn.presentation.dto.request.CreateLessonRequestDto;
import hello.cluebackend.domain.learn.presentation.dto.request.UpdateLessonRequestDto;
import hello.cluebackend.domain.learn.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {
  private final LessonService lessonService;

  @PostMapping
  public ResponseEntity<Lesson> createLesson(@RequestBody CreateLessonRequestDto request){
    return ResponseEntity.ok(lessonService.createLesson(request));
  }

  @GetMapping
  public ResponseEntity<List<Lesson>> getAllLessons() {
    return ResponseEntity.ok(lessonService.getAllLessons());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Lesson> getLesson(@PathVariable Long id){
    return ResponseEntity.ok(lessonService.getLessonById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Lesson> updateLesson(@PathVariable Long id, @RequestBody UpdateLessonRequestDto request) {
    return ResponseEntity.ok(lessonService.updateLesson(id, request));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
    lessonService.deleteLesson(id);
    return ResponseEntity.noContent().build();
  }
}
