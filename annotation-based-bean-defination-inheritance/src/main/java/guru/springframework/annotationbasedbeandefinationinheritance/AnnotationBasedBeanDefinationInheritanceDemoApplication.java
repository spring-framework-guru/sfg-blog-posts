package guru.springframework.annotationbasedbeandefinationinheritance;

import guru.springframework.annotationbasedbeandefinationinheritance.config.AppConfig;
import guru.springframework.annotationbasedbeandefinationinheritance.domain.EPubBook;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AnnotationBasedBeanDefinationInheritanceDemoApplication {

    public static void main(String[] args) {
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
