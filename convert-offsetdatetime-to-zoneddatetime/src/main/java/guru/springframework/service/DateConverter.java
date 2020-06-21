package guru.springframework.service;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface DateConverter {

    public ZonedDateTime convertToZonedDateTime();

    public ZonedDateTime convertToAtZoneSameInstant();

    public ZonedDateTime convertToAtZoneSimilarLocal();

}
