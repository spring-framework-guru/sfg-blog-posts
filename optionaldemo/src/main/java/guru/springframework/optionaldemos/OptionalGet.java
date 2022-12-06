package guru.springframework.optionaldemos;

import java.util.Optional;

public class OptionalGet {
    public static void main(String[] args) {
        Optional op1 = Optional.of("Hello World");
        System.out.println(op1.orElse("Default Value"));
        Optional opt2=Optional.empty();
        System.out.println(opt2.orElse("Default Value"));

    }
}
