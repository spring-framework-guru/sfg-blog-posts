package guru.springframework.xmlbasedbeandefinationinheritance;

import guru.springframework.xmlbasedbeandefinationinheritance.domain.Book;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class XMLBasedBeanDefinationInheritanceDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        Book book = (Book)context.getBean("BookBean");
        System.out.println("Book Details: " +book);
    }

}
