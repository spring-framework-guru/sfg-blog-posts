package guru.springframework.domain.multithreading;

import lombok.Synchronized;

public class SynchronizedDemo {
    private int counter;
    private static int decrementCounter =100;
    @Synchronized
    public void increment() {
        counter++;
        System.out.println(counter);
    }
    @Synchronized
    public static void decrement() {
        decrementCounter--;
        System.out.println(decrementCounter);
    }

}
