package guru.springframework.hikaricp.bootsrap;

import guru.springframework.hikaricp.domain.Employee;
import guru.springframework.hikaricp.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class InitializeEmployeeData implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;

    public InitializeEmployeeData(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employeeES=new Employee("Eric","Smith","eric@example.com");
        Employee savedES=employeeRepository.save(employeeES);

        Employee employeePP=new Employee("Pamela","Parker","pamela@example.com");
        Employee savedPP=employeeRepository.save(employeePP);

        employeeRepository.findAll().forEach(employee -> {
            System.out.println("First Name: " + employee.getFirstName());
            System.out.println("Last Name: " + employee.getLastName());
            System.out.println("Email: " + employee.getEmail());

        });


    }
}
