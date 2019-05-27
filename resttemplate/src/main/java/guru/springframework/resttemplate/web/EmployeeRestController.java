package guru.springframework.resttemplate.web;

import guru.springframework.resttemplate.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Very simple REST Web-Service to manage employees and demonstrate the usage of class RestTemplate.
 * Please see class EmployeeRestControllerIntegrationTest to see RestTemplate in action.
 */
@RestController
@RequestMapping("/rest/employees")
public class EmployeeRestController {

  private static final Map<Long, Employee> employees;
  private static Long nextID = 1L;

  static {
    employees = new HashMap<>();
    employees.put(nextID, new Employee(nextID++, "John", "Doe", 80000));
    employees.put(nextID, new Employee(nextID++, "Mary", "Jackson", 75000));
    employees.put(nextID, new Employee(nextID++, "Peter", "Grey", 60000));
    employees.put(nextID, new Employee(nextID++, "Max", "Simpson", 67000));
    employees.put(nextID, new Employee(nextID++, "Lisa", "O'Melly", 45000));
    employees.put(nextID, new Employee(nextID++, "Josephine", "Rose", 52000));
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Employee> get(@PathVariable long id) {
    Optional<Employee> employee = Optional.ofNullable(employees.get(id));

    return ResponseEntity.of(employee);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Collection<Employee>> getAll(@RequestParam(name = "page", defaultValue = "1") int page,
                                                     @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
    List<Employee> employeesSubList = calculateEmployeeSubList(page, pageSize);
    return ResponseEntity.ok(employeesSubList);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
               produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Employee> create(@RequestBody Employee newEmployee) {
    newEmployee.setId(nextID++);
    employees.put(newEmployee.getId(), newEmployee);

    return ResponseEntity.status(HttpStatus.CREATED)
            .header("Location", "/rest/employees/" + newEmployee.getId())
            .body(newEmployee);
  }

  @PutMapping(path = "/{id}",
              consumes = MediaType.APPLICATION_JSON_VALUE,
              produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Employee> update(@PathVariable long id, @RequestBody Employee request) {
    if (! employees.containsKey(id)) {
      return ResponseEntity.notFound().build();
    }
    else {
      Employee employee = employees.get(id);
      employee.setFirstName(request.getFirstName());
      employee.setLastName(request.getLastName());
      employee.setYearlyIncome(request.getYearlyIncome());

      return ResponseEntity.ok(employee);
    }
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable long id) {
    Employee removedEmployee = employees.remove(id);

    return removedEmployee != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
  }

  private List<Employee> calculateEmployeeSubList(int page, int pageSize) {
    List<Employee> employeeList = new ArrayList<>(employees.values());

    int startIndex = page * pageSize - pageSize;
    int endIndex = Math.min(page * pageSize, employees.size());

    try {
      return employeeList.subList(startIndex, endIndex);
    }
    catch (Exception e) {
      return Collections.emptyList();
    }
  }

}
