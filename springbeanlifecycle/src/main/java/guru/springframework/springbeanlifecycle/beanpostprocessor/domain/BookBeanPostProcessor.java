package guru.springframework.springbeanlifecycle.beanpostprocessor.domain;

import guru.springframework.springbeanlifecycle.beanpostprocessor.domain.BookBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BookBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Post Process Before Initialization method is called : Bean Name " + beanName);
        return bean;    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Post Process After Initialization method is called : Bean Name " + beanName);

        return bean;
    }
}
