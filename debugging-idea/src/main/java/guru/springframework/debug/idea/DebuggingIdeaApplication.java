package guru.springframework.debug.idea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DebuggingIdeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DebuggingIdeaApplication.class, args);

        DebugExampleOne exampleOne = new DebugExampleOne();
        exampleOne.printValue();

        DebugExampleTwo exampleTwo = new DebugExampleTwo();
        for (DebugExampleTwo.Container container : exampleTwo.getContainers()) {
            System.out.println("Container value -> " + container.getValue());
        }
    }

}
