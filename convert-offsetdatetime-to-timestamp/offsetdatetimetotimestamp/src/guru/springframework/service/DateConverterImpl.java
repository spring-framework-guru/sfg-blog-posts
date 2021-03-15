package guru.springframework.service;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class DateConverterImpl implements DateConverter {


    public Timestamp asTimestamp(OffsetDateTime offsetDateTime) {
        System.out.println("OffsetDateTime: " + offsetDateTime);

        if (offsetDateTime != null) {
            return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        } else {
            return null;
        }
    }

    public Timestamp timestampZone(OffsetDateTime offsetDateTime) {
        if (offsetDateTime != null)
            //return Timestamp.valueOf(OffsetDateTime.now().toLocalDateTime());
            return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneId.of("Asia/Shanghai")).toLocalDateTime());
        else
            return null;
    }

    public Timestamp timestampDate(OffsetDateTime offsetDateTime) {
        if (offsetDateTime != null)
            return Timestamp.valueOf(OffsetDateTime.now().toLocalDate().atStartOfDay());
        else
            return null;
    }

}