package guru.springframework;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        DateConvertor dateConvertor = new DateConvertor();

        dateConvertor.getDateTimeWithOffset();

        dateConvertor.convertToZonedDateTime();

        dateConvertor.convertToAtZoneSameInstant();

        dateConvertor.convertToAtZoneSimilarLocal();

    }
}
