package guru.springframework.externalconfiguration;

import guru.springframework.externalconfiguration.config.ConnectionSettings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ConnectionSettingsConfigurationTest {

    @Autowired
    private ConnectionSettings connectionSettings;

    @Test
    public void shouldListConnectionNamesWhenPropertiesFileInjected(){
        assertThat(connectionSettings.getNames()).containsOnly("test","live");
    }

    @Test
    public void shouldInjectConnectionSettingsMapWhenPropertiesFileInjected(){
        assertThat(connectionSettings.getAddresses()).containsOnlyKeys("test","live");
    }

}
