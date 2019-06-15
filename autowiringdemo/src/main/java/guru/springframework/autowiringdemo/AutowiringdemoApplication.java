package guru.springframework.autowiringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AutowiringdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AutowiringdemoApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("*** Example Using byName autowiring mode ***");
		Employee emp = context.getBean("employeeByName", Employee.class);
		emp.setEid(101);
		emp.setEname("Spring Framework Guru");
		emp.showEployeeDetails();

		System.out.println("\n*** Example Using byType autowiring mode ***");
		Employee emp1 = context.getBean("employeeByType", Employee.class);
		emp1.setEid(102);
		emp1.setEname("Spring Framework Guru");
		emp1.showEployeeDetails();

		System.out.println("\n*** Example Using constructor autowiring mode ***");
		Employee emp2 = context.getBean("employeeConstructor", Employee.class);
		emp2.setEid(103);
		emp2.setEname("Spring Framework Guru");
		emp2.showEployeeDetails();

		System.out.println("\n*** Example Using @Autowire annotation on property ***");
		EmployeeBean employeeBean = ctx.getBean(EmployeeBean.class);
		employeeBean.setEid(104);
		employeeBean.setEname("Spring Framework Guru");
		employeeBean.showEployeeDetails();
	}

}
