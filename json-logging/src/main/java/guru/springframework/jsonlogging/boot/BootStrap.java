package guru.springframework.jsonlogging.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt, Spring Framework Guru.
 */
@Slf4j
@Component
public class BootStrap implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.debug("Debugging log");
        log.info("Info log");
        log.warn("Warning log");
        log.error("Error log");
    }
}
