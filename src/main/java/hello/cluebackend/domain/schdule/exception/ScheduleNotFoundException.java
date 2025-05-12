package hello.cluebackend.domain.schdule.exception;

public class ScheduleNotFoundException extends RuntimeException {
  public ScheduleNotFoundException(String message) {
    super(message);
  }
}