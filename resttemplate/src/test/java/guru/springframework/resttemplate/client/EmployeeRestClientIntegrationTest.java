package guru.springframework.resttemplate.client;

import com.fasterxml.jackson.databind.JsonNode;
import guru.springframework.resttemplate.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeRestClientIntegrationTest {

  // Test employees
  private Employee johnDoe     = new Employee(1, "John", "Doe", 80000);
  private Employee maryJackson = new Employee(2, "Mary", "Jackson", 75000);
  private Employee peterGrey   = new Employee(3, "Peter", "Grey", 60000);

  @LocalServerPort
  private int port;

  @Autowired
  private RestTemplate restTemplate;

  private EmployeeRestClient client;

  @BeforeEach
  void setup() {
    assertNotNull(restTemplate);
    client = new EmployeeRestClient(restTemplate, "http://localhost", port);
  }

  @Test
  void test_getForEntity() {
    ResponseEntity<Employee> entity = client.getForEntity(1);

    assertNotNull(entity);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertNotNull(entity.getBody());
    assertEquals(johnDoe, entity.getBody());
  }

  @Test
  void test_getForEntityNotFound() {
    ResponseEntity<Employee> entity = client.getForEntity(-1);

    assertNotNull(entity);
    assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
    assertNull(entity.getBody());
  }

  @Test
  void test_getAll() {
    List<Employee> employees = client.getAll(1, 3);

    assertNotNull(employees);
    assertEquals(3, employees.size());
    assertEquals(johnDoe, employees.get(0));
    assertEquals(maryJackson, employees.get(1));
    assertEquals(peterGrey, employees.get(2));
  }

  @Test
  void test_getForObject() {
    Optional<Employee> employee = client.getForObject(2);

    assertNotNull(employee);
    assertTrue(employee.isPresent());
    assertEquals(maryJackson, employee.get());
  }

  @Test
  void test_getAsJsonNode() throws Exception {
    JsonNode jsonNode = client.getAsJsonNode(3);

    assertNotNull(jsonNode);
    assertEquals(peterGrey.getId(), jsonNode.path("id").asLong());
    assertEquals(peterGrey.getFirstName(), jsonNode.path("firstName").asText());
    assertEquals(peterGrey.getLastName(), jsonNode.path("lastName").asText());
    assertEquals(peterGrey.getYearlyIncome(), jsonNode.path("yearlyIncome").asLong());
  }

  @Test
  void test_postForObject() {
    Employee employeeToCreate = new Employee();
    employeeToCreate.setFirstName("Daniel");
    employeeToCreate.setLastName("Thomson");
    employeeToCreate.setYearlyIncome(65000);

    Employee createdEmployee = client.postForObject(employeeToCreate);

    assertNotNull(createdEmployee);
    assertTrue(createdEmployee.getId() != 0);
    assertEquals("Daniel", createdEmployee.getFirstName());
    assertEquals("Thomson", createdEmployee.getLastName());
    assertEquals(65000, createdEmployee.getYearlyIncome());
  }

  @Test
  void test_postForLocation() {
    Employee employeeToCreate = new Employee();
    employeeToCreate.setFirstName("Marc");
    employeeToCreate.setLastName("White");
    employeeToCreate.setYearlyIncome(62000);

    URI location = client.postForLocation(employeeToCreate);

    assertNotNull(location);
  }

  @Test
  void test_postForEntity() {
    Employee employeeToCreate = new Employee();
    employeeToCreate.setFirstName("Jessica");
    employeeToCreate.setLastName("Anderson");
    employeeToCreate.setYearlyIncome(69000);

    ResponseEntity<Employee> entity = client.postForEntity(employeeToCreate);

    assertNotNull(entity);
    assertEquals(HttpStatus.CREATED, entity.getStatusCode());
    assertNotNull(entity.getBody());
    assertTrue(entity.getBody().getId() != 0);
    assertEquals("Jessica", entity.getBody().getFirstName());
    assertEquals("Anderson", entity.getBody().getLastName());
    assertEquals(69000, entity.getBody().getYearlyIncome());
  }

  @Test
  void test_put() {
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    Employee employee = client.getForObject(4).get();
    employee.setFirstName("Robb");
    employee.setLastName("Stark");
    employee.setYearlyIncome(99999);

    client.put(employee);

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    Employee updatedEmployee = client.getForObject(4).get();

    assertNotNull(updatedEmployee);
    assertEquals(4, updatedEmployee.getId());
    assertEquals("Robb", updatedEmployee.getFirstName());
    assertEquals("Stark", updatedEmployee.getLastName());
    assertEquals(99999, updatedEmployee.getYearlyIncome());
  }

  @Test
  void test_putWithExchange() {
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    Employee employee = client.getForObject(5).get();
    employee.setFirstName("Robb");
    employee.setLastName("Stark");
    employee.setYearlyIncome(99999);

    ResponseEntity<Employee> entity = client.putWithExchange(employee);

    assertNotNull(entity);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertNotNull(entity.getBody());
    assertEquals(5, entity.getBody().getId());
    assertEquals("Robb", entity.getBody().getFirstName());
    assertEquals("Stark", entity.getBody().getLastName());
    assertEquals(99999, entity.getBody().getYearlyIncome());
  }

  @Test
  void test_delete() {
    client.delete(6);

    assertTrue(client.getForObject(6).isEmpty());
  }

  @Test
  void test_deleteWithExchange() {
    ResponseEntity<Void> entity = client.deleteWithExchange(99);

    assertNotNull(entity);
    assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
  }

  @Test
  void test_headForHeaders() {
    HttpHeaders httpHeaders = client.headForHeaders();

    assertNotNull(httpHeaders.getContentType());
    assertTrue(httpHeaders.getContentType().includes(MediaType.APPLICATION_JSON));
  }

  @Test
  void test_optionsForAllow() {
    Set<HttpMethod> httpMethods = client.optionsForAllow(1);
    List<HttpMethod> expectedHttpMethods = List.of(HttpMethod.GET, HttpMethod.PUT, HttpMethod.DELETE);

    assertTrue(httpMethods.containsAll(expectedHttpMethods));
  }
}