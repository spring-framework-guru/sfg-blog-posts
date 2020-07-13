package guru.springframework.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface DateConverter {
    LocalDateTime convertToLocalDateTime();
    LocalDate convertToLocalDate();
    LocalTime convertToLocalTime();
}
