package guru.springframework.debug.idea;

public class DebugExampleOne {

    private static class Broken {
        private final int value = 1;
    }

    private Broken broken;

    void printValue() {
        System.out.println(broken.value);
    }
}
