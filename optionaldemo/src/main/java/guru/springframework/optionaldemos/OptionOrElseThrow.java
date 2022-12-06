package guru.springframework.optionaldemos;

import java.util.Optional;

public class OptionOrElseThrow {

    public static void main(String[] args) throws Throwable {
        String email= null;
        Optional emailOpt=Optional.ofNullable(email);
        System.out.println(emailOpt.orElseThrow(()->new IllegalArgumentException("Email cannot be null")));
    }
}
