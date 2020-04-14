package guru.springframework.beanscope.config;

import guru.springframework.beanscope.domain.Blog;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.implementation.MethodDelegation.to;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PrototypeDemoTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void getBlog() {
        Blog blogInstance1 = applicationContext.getBean("blog2", Blog.class);
        Blog blogInstance2 = applicationContext.getBean("blog2", Blog.class);
        assertThat(blogInstance1).isNotEqualTo(blogInstance2);
    }
}