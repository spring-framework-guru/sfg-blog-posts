package guru.springframework.resttemplate.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.resttemplate.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.*;

@SuppressWarnings("WeakerAccess")
public class EmployeeRestClient {

  private static final String RESOURCE_PATH = "/rest/employees";

  private Logger LOG = LoggerFactory.getLogger(EmployeeRestClient.class);
  private String REQUEST_URI;
  private RestTemplate restTemplate;

  public EmployeeRestClient(RestTemplate restTemplate, String host, int port) {
    this.restTemplate = restTemplate;
    this.REQUEST_URI = host + ":" + port + RESOURCE_PATH;
  }

  /**
   * Requests the employee resource for the specified id via HTTP GET using RestTemplate method getForEntity.
   * @param id the id of the employee resource
   * @return a ResponseEntity that wraps http status code, http headers and the body of type {@link Employee}
   */
  public ResponseEntity<Employee> getForEntity(long id) {
    ResponseEntity<Employee> entity = restTemplate.getForEntity(REQUEST_URI + "/{id}",
                                                                Employee.class,
                                                                Long.toString(id));

    // LOG.info("Status code value: " + domain.getStatusCodeValue());
    // LOG.info("HTTP Header 'ContentType': " + domain.getHeaders().getContentType());

    return entity;
  }

  /**
   * Requests a specified amount of employee resources via HTTP GET using RestTemplate method getForEntity.
   * The amount is specified by the given page and pageSize parameter.
   * @param page the page
   * @param pageSize the amount of elements per page
   * @return a list of employees
   */
  public List<Employee> getAll(int page, int pageSize) {
    String requestUri = REQUEST_URI + "?page={page}&pageSize={pageSize}";

    Map<String, String> urlParameters = new HashMap<>();
    urlParameters.put("page", Integer.toString(page));
    urlParameters.put("pageSize", Long.toString(pageSize));

    ResponseEntity<Employee[]> entity = restTemplate.getForEntity(requestUri,
                                                                  Employee[].class,
                                                                  urlParameters);

    return entity.getBody() != null? Arrays.asList(entity.getBody()) : Collections.emptyList();
  }

  /**
   * Requests the employee resource for the specified id via HTTP GET using RestTemplate method getForObject.
   * @param id the id of the employee resource
   * @return the employee as {@link Optional} or an empty {@link Optional} if resource not found.
   */
  public Optional<Employee> getForObject(long id) {
    Employee employee = restTemplate.getForObject(REQUEST_URI + "/{id}",
                                                  Employee.class,
                                                  Long.toString(id));

    return Optional.ofNullable(employee);
  }

  /**
   * Requests the employee resource for the specified id via HTTP GET using RestTemplate method getForObject
   * and returns the resource as JsonNode.
   * @param id the id of the employee resource
   * @return the employee resource as JsonNode
   * @throws IOException if received json string can not be parsed
   */
  public JsonNode getAsJsonNode(long id) throws IOException {
    String jsonString =  restTemplate.getForObject(REQUEST_URI + "/{id}",
                                                   String.class,
                                                   id);
    ObjectMapper mapper = new ObjectMapper();

    return mapper.readTree(jsonString);
  }

  /**
   * Creates an employee resource via HTTP POST using RestTemplate method getForObject.
   * @param employee the employee to be created
   * @return the created employee
   */
  public Employee postForObject(Employee employee) {
    return restTemplate.postForObject(REQUEST_URI, employee, Employee.class);
  }

  /**
   * Creates an employee resource via HTTP POST using RestTemplate method getForLocation.
   * @param employee the employee to be created
   * @return the {@link URI} of the created employee
   */
  public URI postForLocation(Employee employee) {
    return restTemplate.postForLocation(REQUEST_URI, new HttpEntity<>(employee));
  }

  /**
   * Creates an employee resource via HTTP POST using RestTemplate method postForEntity.
   * @param newEmployee the employee to be created
   * @return a ResponseEntity that wraps http status code, http headers and the body of type {@link Employee}
   */
  public ResponseEntity<Employee> postForEntity(Employee newEmployee) {
    MultiValueMap<String, String> headers = new HttpHeaders();
    headers.add("User-Agent", "EmployeeRestClient demo class");
    headers.add("Accept-Language", "en-US");

    HttpEntity<Employee> entity = new HttpEntity<>(newEmployee, headers);

    return restTemplate.postForEntity(REQUEST_URI, entity, Employee.class);
  }

  /**
   * Updates an employee resource via HTTP PUT using RestTemplate method put.
   * @param updatedEmployee the employee to be updated
   */
  public void put(Employee updatedEmployee) {
    restTemplate.put(REQUEST_URI + "/{id}",
                      updatedEmployee,
                      Long.toString(updatedEmployee.getId()));
  }

  /**
   * Updates an employee resource via HTTP PUT using RestTemplate method exchange.
   * @param updatedEmployee the employee to be updated
   * @return a ResponseEntity that wraps http status code, http headers and the body of type {@link Employee}
   */
  public ResponseEntity<Employee> putWithExchange(Employee updatedEmployee) {
    return restTemplate.exchange(REQUEST_URI + "/{id}",
                                 HttpMethod.PUT,
                                 new HttpEntity<>(updatedEmployee),
                                 Employee.class,
                                 Long.toString(updatedEmployee.getId()));
  }

  /**
   * Deletes an employee resurce via HTTP DELETE using RestTemplate method delete.
   * @param id the id of the employee to be deleted
   */
  public void delete(long id) {
    restTemplate.delete(REQUEST_URI + "/{id}", Long.toString(id));
  }

  /**
   * Deletes an employee resurce via HTTP DELETE using RestTemplate method exchange.
   * @param id the id of the employee to be deleted
   * @return a ResponseEntity that wraps http status code and http headers
   */
  public ResponseEntity<Void> deleteWithExchange(long id) {
    return restTemplate.exchange(REQUEST_URI + "/{id}",
                                 HttpMethod.DELETE,
                                 null,
                                 Void.class,
                                 Long.toString(id));
  }

  /**
   * Requests the built request URI via HTTP HEAD.
   * @return the HTTP headers for the requested URI.
   */
  public HttpHeaders headForHeaders() {
    return restTemplate.headForHeaders(REQUEST_URI);
  }

  /**
   * Requests the built request URI via HTTP OPTION.
   * @param id the employee to be requested with OPTION
   * @return all allowed HTTP methods for the requested URI
   */
  public Set<HttpMethod> optionsForAllow(long id) {
    return restTemplate.optionsForAllow(REQUEST_URI + "/{id}", Long.toString(id));
  }

}
