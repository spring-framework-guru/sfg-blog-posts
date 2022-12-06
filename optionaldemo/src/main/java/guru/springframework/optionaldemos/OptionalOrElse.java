package guru.springframework.optionaldemos;

import java.util.Optional;
import java.util.Random;

public class OptionalOrElse {

    public static void main(String[] args) {
        extracted(10);
    }

    private static void extracted(int num) {
        Optional<Integer> op
                = Optional.empty();
        // print value
        System.out.println("Optional: "
                + op);

    if(op.isEmpty())

            // orElse value
            System.out.println("Value by orElse "
                    + op.orElse(100));
        }

    }




