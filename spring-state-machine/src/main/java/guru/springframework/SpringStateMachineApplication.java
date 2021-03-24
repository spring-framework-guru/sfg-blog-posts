package guru.springframework;

import guru.springframework.domain.BlogEvents;
import guru.springframework.domain.BlogStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;

@SpringBootApplication
@EnableStateMachine
public class SpringStateMachineApplication implements CommandLineRunner {

    private final StateMachine<BlogStates, BlogEvents> stateMachine;

    @Autowired
    public SpringStateMachineApplication(StateMachine<BlogStates, BlogEvents> stateMachine) {
        this.stateMachine = stateMachine;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringStateMachineApplication.class, args);
    }

    @Override
    public void run(String... args) {
        stateMachine.start();
        stateMachine.sendEvent(BlogEvents.EDIT_BLOG);
//        stateMachine.sendEvent(BlogEvents.PUBLISH_BLOG);
        stateMachine.stop();
    }
}