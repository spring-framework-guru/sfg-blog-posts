package guru.springframework;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateConvertor {
    ZoneId zoneId = ZoneId.of("Asia/Kolkata");
    OffsetDateTime offsetDateTime;

    public OffsetDateTime getDateTimeWithOffset() {
        offsetDateTime = OffsetDateTime.now();
        System.out.println(offsetDateTime);
        return offsetDateTime;
    }

    public ZonedDateTime convertToZonedDateTime() {
        ZonedDateTime zonedDateTime1 = offsetDateTime.toZonedDateTime();
        System.out.println(zonedDateTime1);
        return zonedDateTime1;
    }

    public ZonedDateTime convertToAtZoneSameInstant() {
        ZonedDateTime zonedDateTime2 = offsetDateTime.atZoneSameInstant(zoneId);
        System.out.println(zonedDateTime2);
        return zonedDateTime2;
    }

    public ZonedDateTime convertToAtZoneSimilarLocal() {
        ZonedDateTime zonedDateTime3 = offsetDateTime.atZoneSimilarLocal(zoneId);
        System.out.println(zonedDateTime3);
        return zonedDateTime3;
    }

}
