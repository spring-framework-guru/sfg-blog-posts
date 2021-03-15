package guru.springframework;

import guru.springframework.service.DateConverter;
import guru.springframework.service.DateConverterImpl;

import java.time.OffsetDateTime;


public class Main {
    public static void main(String[] args) {
        DateConverter dateConvertor = new DateConverterImpl();

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("SqlTimestamp: " + dateConvertor.asTimestamp(offsetDateTime));

        System.out.println("Timestamp : " + dateConvertor.timestampZone(offsetDateTime));

        System.out.println(dateConvertor.timestampDate(offsetDateTime));
    }
}
