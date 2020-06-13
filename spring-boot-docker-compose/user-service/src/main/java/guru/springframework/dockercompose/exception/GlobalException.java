package guru.springframework.dockercompose.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * @ControllerAdvice annotation provided by Spring allows you to write global
 * code that can be applied to a wide range of controllers
 */
@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    /*
     * to get property value
     */
    @Value("${app.globalExceptionMessage}")
    private String globalExceptionMessage;

    @Value("${app.exceptionMessage}")
    private String exceptionMessage;


    /**
     * Handles UserAlreadyExists exception
     */
    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public ResponseEntity<String> notFoundException(UserAlreadyExistsException exception) {
        return new ResponseEntity<String>(exceptionMessage, HttpStatus.CONFLICT);
    }


    /**
     * Handles Internal_Server_Error i.e if database connection fails
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> databaseConnectionFailsException(Exception exception) {
        return new ResponseEntity<>(globalExceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}