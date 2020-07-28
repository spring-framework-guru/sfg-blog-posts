package guru.springframework.externalconfiguration.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@ConfigurationProperties(prefix = "connection")
@Component
@Data
public class ConnectionSettings {

    List<String> names;
    Map<String, String> addresses;
}
