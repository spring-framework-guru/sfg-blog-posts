package guru.springframework.optionaldemos;

import java.util.Optional;

public class OptionalRetrieval
{
    public static void main(String[] args) {
        Optional op1 = Optional.empty();
        System.out.println(op1.isEmpty());
        System.out.println(op1.isPresent());
        Optional op2 = Optional.of("Optional");
        System.out.println(op2.isEmpty());
        System.out.println(op2.isPresent());
    }
}
