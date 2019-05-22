package com.blog.post.dependencyInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class JavaConfiguration {
    @Bean(name = "newName")
    public MyFirstBean myFirstBean (){
        return new MyFirstBean();

    }
    @Bean
    public BeanWithDependency beanWithDependency(){
        BeanWithDependency beanWithDependency= new BeanWithDependency();
        beanWithDependency.setMyFirstBean(myFirstBean());
        return beanWithDependency;
    }

}
