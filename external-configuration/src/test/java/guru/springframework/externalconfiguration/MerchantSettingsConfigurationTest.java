package guru.springframework.externalconfiguration;

import guru.springframework.externalconfiguration.config.MerchantAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MerchantSettingsConfigurationTest {

    @Autowired
    private MerchantAccount merchantAccount;

    @Test
    public void shouldContainNonNullMerchantAccountWhenPropertiesFileInjected(){
        assertThat(merchantAccount).hasNoNullFieldsOrProperties();
    }


}
