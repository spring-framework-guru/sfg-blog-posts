package guru.springframework.springrestexception.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Value;
import org.springframework.http.HttpStatus;

@Value
public final class ErrorMessage {

  HttpStatus status;
  String reason;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  LocalDateTime timestamp;

  public ErrorMessage(HttpStatus status, String reason) {
    this.status = status;
    this.reason = reason;
    this.timestamp = LocalDateTime.now();
  }

  public ErrorMessage(HttpStatus status) {
    this.status = status;
    this.reason = "Unknown error";
    this.timestamp = LocalDateTime.now();
  }
}
