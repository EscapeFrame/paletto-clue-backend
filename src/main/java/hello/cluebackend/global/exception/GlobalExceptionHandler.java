package hello.cluebackend.global.exception;

import hello.cluebackend.domain.schdule.exception.ScheduleNotFoundException;
import hello.cluebackend.global.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ScheduleNotFoundException.class)
  public ResponseEntity<ApiResponse<Void>> handleScheduleNotFoundException(ScheduleNotFoundException e) {
    log.error("시간표를 찾을 수 없음: {}", e.getMessage());
    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ApiResponse.error(e.getMessage()));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse<List<String>>> handleValidationExceptions(
          MethodArgumentNotValidException e) {

    BindingResult bindingResult = e.getBindingResult();
    List<String> errorMessages = bindingResult.getFieldErrors().stream()
            .map(FieldError::getDefaultMessage)
            .collect(Collectors.toList());

    log.error("입력값 유효성 검증 실패: {}", errorMessages);

    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ApiResponse.error(String.join(", ", errorMessages)));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<Void>> handleAllExceptions(Exception e) {
    log.error("예상치 못한 오류 발생", e);
    return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ApiResponse.error("서버 내부 오류가 발생했습니다. 관리자에게 문의하세요."));
  }
}