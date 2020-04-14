package guru.springframework.beanscope.config;

import guru.springframework.beanscope.domain.Blog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PrototypeDemo {
    @Bean(name = "blog2")
    @Scope("prototype")
    public Blog getBlog() {
        return new Blog();
    }
}
