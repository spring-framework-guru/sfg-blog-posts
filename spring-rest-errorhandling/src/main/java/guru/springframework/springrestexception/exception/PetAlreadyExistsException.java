package guru.springframework.springrestexception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class PetAlreadyExistsException extends ServiceException {

  public PetAlreadyExistsException(String message) {
    super(message);
  }

  public PetAlreadyExistsException(String message, Throwable cause) {
    super(message, cause);
  }
}
