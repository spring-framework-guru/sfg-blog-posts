package guru.springframework.service;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateConverterImpl implements DateConverter{
    ZoneId zoneId = ZoneId.of("Asia/Kolkata");

    public ZonedDateTime convertToZonedDateTime() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        ZonedDateTime zonedDateTime1 = offsetDateTime.toZonedDateTime();
        System.out.println(zonedDateTime1);
        return zonedDateTime1;
    }

    public ZonedDateTime convertToAtZoneSameInstant() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        ZonedDateTime zonedDateTime2 = offsetDateTime.atZoneSameInstant(zoneId);
        System.out.println(zonedDateTime2);
        return zonedDateTime2;
    }

    public ZonedDateTime convertToAtZoneSimilarLocal() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        ZonedDateTime zonedDateTime3 = offsetDateTime.atZoneSimilarLocal(zoneId);
        System.out.println(zonedDateTime3);
        return zonedDateTime3;
    }

}
