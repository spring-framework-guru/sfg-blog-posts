package guru.springframework.beanscope.config;

import guru.springframework.beanscope.domain.Author;
import guru.springframework.beanscope.domain.Blog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SingletonInjectedPrototypeDemo {
    @Bean(name = "blog3")
    @Scope("singleton")
    public Blog getBlog() {
        return new Blog();
    }

    @Bean(name = "author1")
    @Scope("prototype")
    public Author getAuthor() {
        return new Author();
    }

}
