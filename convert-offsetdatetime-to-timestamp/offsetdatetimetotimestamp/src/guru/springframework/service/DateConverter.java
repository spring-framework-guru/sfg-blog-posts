package guru.springframework.service;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

public interface DateConverter {


    Timestamp asTimestamp(OffsetDateTime offsetDateTime);

    Timestamp timestampZone(OffsetDateTime offsetDateTime);

    Timestamp timestampDate(OffsetDateTime offsetDateTime);
}
