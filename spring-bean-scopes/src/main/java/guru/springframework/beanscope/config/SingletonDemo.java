package guru.springframework.beanscope.config;

import guru.springframework.beanscope.domain.Blog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SingletonDemo {
    @Bean(name = "blog1")
    @Scope("singleton")
    public Blog getBlog() {
        return new Blog();
    }
}
