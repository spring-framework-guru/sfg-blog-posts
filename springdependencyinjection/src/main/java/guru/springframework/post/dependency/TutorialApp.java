package guru.springframework.post.dependency;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@SpringBootApplication
public class TutorialApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(JavaConfiguration.class);
		ctx.refresh();
		MyFirstBean myFirstBean=(MyFirstBean)ctx.getBean("myFirstBean");
		MyFirstBean secondBean=(MyFirstBean)ctx.getBean("otherName");

		System.out.println(myFirstBean);
		System.out.println("-------");
		System.out.println("Other instance "+secondBean);

    }

}
