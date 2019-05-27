package guru.springframework.resourceloaderdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import guru.springframework.resourceloaderdemo.service.ResourceLoaderService;

@SpringBootApplication
public class ResoruceloaderdemoApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SpringApplication.run(ResoruceloaderdemoApplication.class, args);

		ApplicationContext ctx = new AnnotationConfigApplicationContext("guru.springframework.resourceloaderdemo.service");
		ResourceLoaderService loader = (ResourceLoaderService) ctx.getBean("resourceLoaderService");
		try {
			loader.showResourceDataUsingRoot();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("** Resource loader using file path **");

		try {
			loader.showResourceDataUsingFilePath();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("** Resource loader using class path **");

		try {
			loader.showResourceDataUsingClassPath();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("** Resource loader using URL **");

		try {
			loader.showResourceDataUsingURL();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
