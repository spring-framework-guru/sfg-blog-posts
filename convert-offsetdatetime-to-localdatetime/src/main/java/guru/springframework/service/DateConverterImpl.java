package guru.springframework.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

public class DateConverterImpl implements DateConverter{

    public LocalDateTime convertToLocalDateTime() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println(offsetDateTime);
        LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();
        System.out.println(localDateTime);
        return  localDateTime;
    }

    public LocalDate convertToLocalDate() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println(offsetDateTime);
        LocalDate localDate=offsetDateTime.toLocalDate();
        System.out.println(localDate);
        return  localDate;
    }

    public LocalTime convertToLocalTime() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println(offsetDateTime);
        LocalTime localTime=offsetDateTime.toLocalTime();
        System.out.println(localTime);
        return  localTime;
    }


}
