package guru.springframework.springrestexception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PetNotFoundException extends ServiceException {

  public PetNotFoundException(String message) {
    super(message);
  }

  public PetNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
