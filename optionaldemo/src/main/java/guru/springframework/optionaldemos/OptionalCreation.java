package guru.springframework.optionaldemos;

import java.util.Optional;

public class OptionalCreation {

    public static void main(String[] args) {
        emptyOptioal();
        optionalOf();
        // Possible null value
        Optional<String> optional = Optional.ofNullable(getName());
        System.out.println(optional);


    }
    private static String getName(){
        String name = "Im an Optional";
        return (name.length() > 5) ? name :  null;
    }

    private static void optionalOf() {
        String name = "Optional";
        Optional<String> opt = Optional.of(name);
        System.out.println(opt);
    }

    private static void emptyOptioal() {
        /*Empty Optional*/
        Optional<String> empty = Optional.empty();
        if(empty.isEmpty()){
            System.out.println("I am an empty optional");
        }
    }
}
