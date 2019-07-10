package guru.springframework;

import guru.springframework.annotationbasedbeandefinitioninheritance.config.AppConfig;
import guru.springframework.annotationbasedbeandefinitioninheritance.domain.EPubBook;
import guru.springframework.xmlbasedbeandefinitioninheritance.domain.Book;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BeanDefinitionInheritanceDemoApplication {

    public static void main(String[] args) {
        //XML based Bean Definition Test\
        System.out.println("XML based Bean Definition Inheritance Test");
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Book book = (Book) context.getBean("BookBean");
        System.out.println("Book Details: " + book);


        //Annotation based Bean Definition Test
        System.out.println("Annotation based Bean Definition Inheritance Test");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        EPubBook ePubBook = ctx.getBean(EPubBook.class);
        System.out.println("Author Name: " + ePubBook.getAuthorName());
        System.out.println("Book Name: " + ePubBook.getBookName());
        System.out.println("Book Price: " + ePubBook.getBookPrice());
        System.out.println("Download URL: " + ePubBook.getDownloadUrl());
        ctx.registerShutdownHook();
    }

}
