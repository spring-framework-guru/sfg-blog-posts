package guru.springframework;

public class CustomRetryException extends RuntimeException {

    public CustomRetryException(String msg) {
        super(msg);
    }

    public CustomRetryException(String msg, Exception ex) {
        super(msg, ex);
    }
}
