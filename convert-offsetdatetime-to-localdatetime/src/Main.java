import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Main {
    public static void main(String[] args) {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println(offsetDateTime);

        LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();
        System.out.println("localDateTime = " + localDateTime);

        LocalTime localTime = offsetDateTime.toLocalTime();
        System.out.println("localTime = " + localTime);
    }
}
