    package guru.springframework.service;

    import java.time.ZonedDateTime;

    public interface DateConverter {
        public ZonedDateTime convertToZonedDateTime();
        public ZonedDateTime convertToAtZoneSameInstant();
        public ZonedDateTime convertToAtZoneSimilarLocal();
    }
