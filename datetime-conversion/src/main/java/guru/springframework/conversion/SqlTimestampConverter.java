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
    return OffsetDateTime.of(timestamp.toLocalDateTime().getYear(),
                             timestamp.toLocalDateTime().getMonthValue(),
                             timestamp.toLocalDateTime().getDayOfMonth(),
                             timestamp.toLocalDateTime().getHour(),
                             timestamp.toLocalDateTime().getMinute(),
                             timestamp.toLocalDateTime().getSecond(),
                             timestamp.toLocalDateTime().getNano(),
                             ZoneOffset.UTC);
  }

  public static ZonedDateTime toZonedDateTime(Timestamp timestamp) {
    return null;
  }

  public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
    return null;
  }

}
