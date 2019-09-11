package guru.springframework.domain.multithreading;

import lombok.Synchronized;

public class SynchronizedDemo {
    private int counter;
    @Synchronized
    final void start() {
        counter++;
        System.out.println(counter);
    }
}
