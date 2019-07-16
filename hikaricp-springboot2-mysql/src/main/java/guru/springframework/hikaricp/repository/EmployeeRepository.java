package guru.springframework.hikaricp.repository;

import guru.springframework.hikaricp.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
