package guru.springframework.optionaldemos;

import java.util.Optional;
import java.util.function.Predicate;

public class OptionalFilterMap {

    public static void main(String[] args) {
        filterDemo();
        mapDemo();
    }

    private static void mapDemo() {
        Optional<String> opt1=Optional.of("Hello! Optional Example");
        System.out.println(opt1.map(String::toUpperCase).get());
    }

    private static void filterDemo() {
        Optional opt1=Optional.of("Hello! Optional Example");
        Predicate<String> predicate1 = s -> s.contains("Example");
        Optional<String> result1 = opt1.filter(predicate1);
        System.out.println(result1.isPresent());

        Predicate<String> predicate2 = s -> s.startsWith("Hello");
        Optional<String> result2 = opt1.filter(predicate2);
        System.out.println(result2.isPresent());
    }
}
