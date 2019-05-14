package guru.springframework.springfactorymethod.avengers.domain.exception;

public abstract class ParserException extends RuntimeException {

  public ParserException(String message) {
    super(message);
  }

  public ParserException(String message, Throwable cause) {
    super(message, cause);
  }
}
