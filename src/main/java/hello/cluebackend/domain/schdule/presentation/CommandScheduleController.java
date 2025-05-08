package hello.cluebackend.domain.schdule.presentation;

import hello.cluebackend.domain.schdule.presentation.dto.request.UpdateScheduleRequest;
import hello.cluebackend.domain.schdule.presentation.dto.response.UpdateScheduleResponse;
import hello.cluebackend.domain.schdule.service.CommandScheduleService;
import hello.cluebackend.global.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://0.0.0.0:3000")
@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class CommandScheduleController {
  private final CommandScheduleService commandScheduleService;

  // 시간표 업데이트 기능
  @PutMapping("/update-subject")
  public ResponseEntity<ApiResponse<UpdateScheduleResponse>> updateSubjectName(
          @Validated @RequestBody UpdateScheduleRequest request) {

    UpdateScheduleResponse updated = UpdateScheduleResponse.from(commandScheduleService.updateSubjectName(
            UpdateScheduleResponse.builder()
                    .classNumber(request.getClassNumber())
                    .dayOfWeek(request.getDayOfWeek())
                    .period(request.getPeriod())
                    .subjectName(request.getSubjectName())
                    .teacherName(request.getTeacherName())
                    .build()));

    ApiResponse<UpdateScheduleResponse> response = ApiResponse.success(updated, "시간표가 성공적으로 수정되었습니다.");
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}