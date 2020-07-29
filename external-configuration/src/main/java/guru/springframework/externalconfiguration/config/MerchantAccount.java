package guru.springframework.externalconfiguration.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "merchantaccount")
public class MerchantAccount {

    private String name;
    private String username;
    private String code;
    private int number;
    private String currency;
}
