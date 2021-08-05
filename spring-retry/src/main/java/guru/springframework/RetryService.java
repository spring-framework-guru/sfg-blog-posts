package guru.springframework;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

public interface RetryService {

    @Retryable(value = {CustomRetryException.class}, maxAttempts = 3, backoff = @Backoff(200))
    public String retry() throws CustomRetryException;
}
