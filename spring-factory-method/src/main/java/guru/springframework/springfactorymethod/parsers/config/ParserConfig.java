package guru.springframework.springfactorymethod.parsers.config;

import guru.springframework.springfactorymethod.parsers.ContentType;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserConfig {

  @Bean("parserFactory")
  public FactoryBean serviceLocatorFactoryBean() {
    ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
    factoryBean.setServiceLocatorInterface(ContentType.ParserFactory.class);
    return factoryBean;
  }
}
