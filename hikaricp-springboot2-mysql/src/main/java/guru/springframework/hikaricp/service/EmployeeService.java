package guru.springframework.hikaricp.service;

import guru.springframework.hikaricp.domain.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void delete(int id);
}
