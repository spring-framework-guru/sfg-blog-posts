package guru.springframework.hikaricp.controller;

import guru.springframework.hikaricp.domain.Employee;
import guru.springframework.hikaricp.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Simanta
 */
@RestController
@RequestMapping("api/vi")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    @RequestMapping("employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
       Employee savedEmployee = employeeRepository.save(employee);
       return (new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED));
    }

    @GetMapping
    @RequestMapping("employees")
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestBody Employee employee){
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeList::add);
        return (new ResponseEntity<List<Employee>>(employeeList, HttpStatus.CREATED));
    }
}
