package guru.springframework.domain.exceptionhandling;

import lombok.SneakyThrows;

public class SneakyThrowDemo implements Runnable {
    @Override
    @SneakyThrows
    public void run() {
        try {
            throw new InterruptedException();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
