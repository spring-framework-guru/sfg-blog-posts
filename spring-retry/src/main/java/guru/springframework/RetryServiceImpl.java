package guru.springframework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetryServiceImpl implements RetryService {

//    private static int count = 0;

    @Override
    public String retry() throws CustomRetryException {
        log.info("Throwing CustomRetryException in method retry");
        throw new CustomRetryException("Throw custom exception");
    }

    @Recover
    public String recover(Throwable throwable) {
        log.info("Default Retry servive test");
        return "Error Class :: " + throwable.getClass().getName();
    }
}
