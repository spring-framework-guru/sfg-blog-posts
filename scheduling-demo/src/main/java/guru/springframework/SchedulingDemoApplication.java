package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Calendar;

@EnableScheduling
@SpringBootApplication
public class SchedulingDemoApplication {
//
//	@Scheduled(initialDelay = 1000, fixedRate = 10000)
//	public void run() {
//		System.out.println("Current time is :: " + Calendar.getInstance().getTime());
//	}

//	@Scheduled(fixedDelay = 10000)
//	public void run() {
//		System.out.println("Current time is :: " + Calendar.getInstance().getTime());
//	}

    @Scheduled(cron = "0 10 10 10 * ?")
    public void scheduleTask() {
      System.out.println("Current time is :: " + Calendar.getInstance().getTime());
//   System.out.println("Printing hello after cron delay: " + System.currentTimeMillis() / 1000);
    }

    public static void main(String[] args) {
        SpringApplication.run(SchedulingDemoApplication.class, args);
    }

}
