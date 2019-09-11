package guru.springframework.domain.logging;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class LoggingDemoTest {
    private LoggingDemo loggingDemo;

    @Before
    public void setUp() throws Exception {
         loggingDemo = new LoggingDemo();

    }

    @After
    public void tearDown() throws Exception {
       loggingDemo=null;
    }

    @Test
    public void performTask() {
        loggingDemo.performTask();
    }
}