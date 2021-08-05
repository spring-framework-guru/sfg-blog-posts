package guru.springframework;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SpringRetryApplicationTest {

    @Autowired
    RetryService retryService;

    @Test
    public void sampleRetryService() {
        try {
            final String message = retryService.retry();
            log.info("message = " + message);
        } catch (CustomRetryException e) {
            log.error("Error while executing test {}", e.getMessage());
        }
    }
}

