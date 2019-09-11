package guru.springframework.domain.logging;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingDemo {
    public void performTask(){
       log.info("Info here");
    }
}
