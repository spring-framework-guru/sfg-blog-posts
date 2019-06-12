package guru.springframework.conversion;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

public class OffsetDateTimeConverter {

  public static ZonedDateTime toZonedDateTime(OffsetDateTime offsetDateTime) {
    return null;
  }

  public static LocalDateTime toLocalDateTime(OffsetDateTime offsetDateTime) {
    return null;
  }

  public static Timestamp toSqlTimestamp(OffsetDateTime offsetDateTime) {
    return null;
  }

}
