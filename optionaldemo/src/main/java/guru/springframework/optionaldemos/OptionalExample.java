package guru.springframework.optionaldemos;

import java.util.Optional;

public class OptionalExample {

    static String convert(String[] strArr, int index){

           return strArr[index].toUpperCase();


    }
    public static void main(String[] args) {
        String res;
        String[] strArr= new String[6];
        Optional<String> checkNull = Optional.ofNullable(strArr[5]);
        if (checkNull.isPresent()) {
            res = convert(strArr, 5);
            System.out.println(res);
        }
        else
        System.out.println("Value is not present");
    }
}