package guru.springframework.conversion;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

public class LocalDateTimeConverter {

  public static OffsetDateTime toOffsetDateTime(LocalDateTime localDateTime) {
    return null;
  }

  public static ZonedDateTime toZonedDateTime(LocalDateTime localDateTime) {
    return null;
  }

  public static Timestamp toSqlTimestamp(LocalDateTime localDateTime) {
    return null;
  }

}
