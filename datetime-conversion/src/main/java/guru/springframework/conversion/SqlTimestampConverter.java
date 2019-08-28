package guru.springframework.conversion;

import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class SqlTimestampConverter {

  @NotNull
  public static OffsetDateTime toOffsetDateTime(@NotNull Timestamp timestamp) {
    LocalDateTime dateTime = timestamp.toLocalDateTime();
    return OffsetDateTime.of(dateTime.getYear(),
                             dateTime.getMonthValue(),
                             dateTime.getDayOfMonth(),
                             dateTime.getHour(),
                             dateTime.getMinute(),
                             dateTime.getSecond(),
                             dateTime.getNano(),
                             ZoneOffset.UTC);
  }

  public static ZonedDateTime toZonedDateTime(Timestamp timestamp) {
    return null;
  }

  public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
    return null;
  }

}
