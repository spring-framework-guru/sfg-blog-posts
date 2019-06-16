package guru.springframework.springrestexception.controller.v3;

import guru.springframework.springrestexception.controller.ErrorMessage;
import guru.springframework.springrestexception.exception.PetAlreadyExistsException;
import guru.springframework.springrestexception.exception.PetNotFoundException;
import guru.springframework.springrestexception.exception.ServiceException;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SuppressWarnings("Duplicates")
@RestControllerAdvice(basePackages = "guru.springframework.springrestexception.controller.v3")
public class ExceptionHandlerControllerAdvice {

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
  protected ResponseEntity<ErrorMessage> handleRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException ex) {

    String error = "HTTP method "
        .concat(ex.getMethod())
        .concat("not allowed; supported methods: ")
        .concat(Arrays.toString(ex.getSupportedMethods()));

    ErrorMessage err = new ErrorMessage(HttpStatus.METHOD_NOT_ALLOWED, error);
    return errResponse(err);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  ResponseEntity<ErrorMessage> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

    String errors = ex
        .getBindingResult()
        .getFieldErrors()
        .stream()
        .map(FieldError::getDefaultMessage)
        .collect(Collectors.joining(","));

    ErrorMessage err = new ErrorMessage(HttpStatus.BAD_REQUEST, errors);
    return errResponse(err);
  }

  @ExceptionHandler(PetAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  ResponseEntity<ErrorMessage> handleAlreadyExists(PetAlreadyExistsException ex) {
    ErrorMessage err = new ErrorMessage(HttpStatus.CONFLICT, ex.getMessage());
    return errResponse(err);
  }

  @ExceptionHandler(PetNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  ResponseEntity<ErrorMessage> handleNotFound(PetNotFoundException ex) {
    ErrorMessage err = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
    return errResponse(err);
  }

  @ExceptionHandler(ServiceException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  ResponseEntity<ErrorMessage> handleInternalErrors(ServiceException ex) {
    ErrorMessage err = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    return errResponse(err);
  }

  private ResponseEntity<ErrorMessage> errResponse(ErrorMessage err) {
    return ResponseEntity.status(err.getStatus()).body(err);
  }
}
