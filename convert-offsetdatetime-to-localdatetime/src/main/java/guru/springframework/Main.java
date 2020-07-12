package guru.springframework;

import guru.springframework.service.DateConverter;
import guru.springframework.service.DateConverterImpl;


public class Main {
    public static void main(String[] args) {
        DateConverter dateConvertor = new DateConverterImpl();
        dateConvertor.convertToLocalDateTime();
        dateConvertor.convertToLocalDate();
        dateConvertor.convertToLocalTime();

    }
}
