package guru.springframework.dockercompose.exception;

public class UserAlreadyExistsException extends Exception {
    private String message;

    public UserAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    public UserAlreadyExistsException() {
    }
}
