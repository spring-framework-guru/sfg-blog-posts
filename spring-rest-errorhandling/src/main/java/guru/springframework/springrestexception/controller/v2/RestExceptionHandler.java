package guru.springframework.springrestexception.controller.v2;

import guru.springframework.springrestexception.exception.ErrorMessage;
import guru.springframework.springrestexception.exception.PetAlreadyExistsException;
import guru.springframework.springrestexception.exception.PetNotFoundException;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings("Duplicates")
@ControllerAdvice(basePackages = "guru.springframework.springrestexception.controller.v2")
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  // override behaviour

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {

    String error = "HTTP method "
        .concat(ex.getMethod())
        .concat("not allowed; supported methods: ")
        .concat(Arrays.toString(ex.getSupportedMethods()));

    ErrorMessage err = new ErrorMessage(HttpStatus.METHOD_NOT_ALLOWED, error);
    return errResponse(err);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    String errors = ex
        .getBindingResult()
        .getFieldErrors()
        .stream()
        .map(FieldError::getDefaultMessage)
        .collect(Collectors.joining(","));

    ErrorMessage err = new ErrorMessage(HttpStatus.BAD_REQUEST, errors);
    return errResponse(err);
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    ErrorMessage err = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    return errResponse(err);
  }

  // custom exceptions

  @ExceptionHandler(PetAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  protected ResponseEntity<Object> handleAlreadyExists(PetAlreadyExistsException ex) {
    ErrorMessage err = new ErrorMessage(HttpStatus.CONFLICT, ex.getMessage());
    return errResponse(err);
  }

  @ExceptionHandler(PetNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  protected ResponseEntity<Object> handleNotFound(PetNotFoundException ex) {
    ErrorMessage err = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
    return errResponse(err);
  }

  private ResponseEntity<Object> errResponse(ErrorMessage err) {
    return ResponseEntity.status(err.getStatus()).body(err);
  }
}
