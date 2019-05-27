package guru.springframework.post.dependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("guru")
public class JavaConfiguration {
    @Bean
    public MyFirstBean myFirstBean (){
        return new MyFirstBean();

    }
    @Bean(value = "otherName")
    public MyFirstBean mySecondBean (){
        return new MyFirstBean();

    }
    @Bean
    public BeanWithDependency beanWithDependency(MyFirstBean myFirstBean){
        BeanWithDependency beanWithDependency= new BeanWithDependency();
        beanWithDependency.setMyFirstBean(myFirstBean);
        return beanWithDependency;
    }

}
