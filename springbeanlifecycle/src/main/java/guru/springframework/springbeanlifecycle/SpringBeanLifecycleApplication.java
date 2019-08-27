package guru.springframework.springbeanlifecycle;

import guru.springframework.springbeanlifecycle.awareinterfaces.domain.AwareBeanImpl;
import guru.springframework.springbeanlifecycle.beanpostprocessor.domain.BookBean;
import guru.springframework.springbeanlifecycle.callbackinterfaces.domain.Book;
import guru.springframework.springbeanlifecycle.custominitanddestroy.domain.BookCustomBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringBeanLifecycleApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBeanLifecycleApplication.class, args);

//		-------callbackinterfaces-------
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        Book book = (Book) context.getBean("bookBean");
        System.out.println(book.getBookName());
        ((AbstractApplicationContext) context).registerShutdownHook();

//		-------awareinterfaces---------
        /*ApplicationContext context1 =
                new ClassPathXmlApplicationContext("beans.xml");
        AwareBeanImpl awareBeanImpl = (AwareBeanImpl) context1.getBean("awareBean");
        ((AbstractApplicationContext) context1).registerShutdownHook();*/

//		-------custominitanddestroy------
       /* ApplicationContext context3 =
                new ClassPathXmlApplicationContext("beans.xml");

        BookCustomBean bookCustomBean = (BookCustomBean) context3.getBean("customLifeCycleBookBean");
        ((AbstractApplicationContext) context3).registerShutdownHook();*/

        //    -------beanpostprocessor------
        /*ApplicationContext context4 =
                new ClassPathXmlApplicationContext("beans.xml");
        BookBean bookBean = (BookBean) context4.getBean("bookBeanPost");
        ((AbstractApplicationContext) context4).registerShutdownHook();*/

   }

}


