import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("Asia/Kolkata");

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println(offsetDateTime);

        ZonedDateTime zonedDateTime1 = offsetDateTime.toZonedDateTime();
        System.out.println(zonedDateTime1);

        ZonedDateTime zonedDateTime2 = offsetDateTime.atZoneSameInstant(zoneId);
        System.out.println(zonedDateTime2);

        ZonedDateTime zonedDateTime3 = offsetDateTime.atZoneSimilarLocal(zoneId);
        System.out.println(zonedDateTime3);

    }
}
