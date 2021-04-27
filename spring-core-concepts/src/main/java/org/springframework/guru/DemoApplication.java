package org.springframework.guru;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.guru.config.BeanConfiguration;
import org.springframework.guru.domain.Book;

public class DemoApplication {
	public static void main(String[] args) {

		//using bean Factory
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("beans.xml"));
		System.out.println(factory);
        Book book= (Book) factory.getBean("book");
        System.out.println(book.getBookPublisher());

        //Using ApplicationContext
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		System.out.println(context);
		Book book1= (Book) context.getBean("book");
		System.out.println(book1.getBookPublisher());

		//Using AnnotationConfigApplicationContext
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.register(BeanConfiguration.class);
		annotationConfigApplicationContext.refresh();
		Book book2 = (Book) annotationConfigApplicationContext.getBean("book");
		System.out.println(book2);
	}

}
