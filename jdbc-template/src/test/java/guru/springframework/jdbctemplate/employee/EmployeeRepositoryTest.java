package guru.springframework.jdbctemplate.employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmployeeRepositoryTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  private EmployeeRepository employeeRepository;

  // expected employees
  private final Employee johnDoe = Employee.builder().id(1).firstName("John").lastName("Doe").yearlyIncome(80000).build();
  private final Employee maryJackson = Employee.builder().id(2).firstName("Mary").lastName("Jackson").yearlyIncome(75000).build();
  private final Employee peterGrey = Employee.builder().id(3).firstName("Peter").lastName("Grey").yearlyIncome(60000).build();

  // employee to create
  private final Employee tomFox = Employee.builder().firstName("Tom").lastName("Fox").yearlyIncome(62000).build();

  @BeforeEach
  void injectedComponentsAreNotNull() {
    assertThat(jdbcTemplate).isNotNull();
    employeeRepository = new EmployeeRepository(jdbcTemplate);
  }

  @AfterEach
  void cleanup() {
    // Delete all employees created during the test
    jdbcTemplate.update("delete from employees where id > 3");
  }

  @Test
  void test_exists_for_existing_employee() {
    boolean exists = employeeRepository.exists(1);

    assertThat(exists).isTrue();
  }

  @Test
  void test_exists_for_not_existing_employee() {
    boolean exists = employeeRepository.exists(-1);

    assertThat(exists).isFalse();
  }

  @Test
  void test_find_one() {
    Employee employee = employeeRepository.findOne(1);

    assertThat(employee).isNotNull();
    assertThat(employee).isEqualTo(johnDoe);
  }

  @Test
  void test_find_all() {
    List<Employee> employees = employeeRepository.findAll();

    assertThat(employees).isNotNull();
    assertThat(employees.size()).isEqualTo(3);
    assertThat(employees.get(0)).isEqualTo(johnDoe);
    assertThat(employees.get(1)).isEqualTo(maryJackson);
    assertThat(employees.get(2)).isEqualTo(peterGrey);
  }

  @Test
  void test_save() {
    employeeRepository.save(tomFox);

    // get last created employee
    List<Employee> employees = employeeRepository.findAll();
    Employee persistentTomFox = employees.get(employees.size() - 1);

    assertThat(persistentTomFox).isNotNull();
    assertThat(persistentTomFox.getFirstName()).isEqualTo(tomFox.getFirstName());
    assertThat(persistentTomFox.getLastName()).isEqualTo(tomFox.getLastName());
    assertThat(persistentTomFox.getYearlyIncome()).isEqualTo(tomFox.getYearlyIncome());
  }

  @Test
  void test_save_and_return_id() {
    long id = employeeRepository.saveAndReturnId(tomFox);

    Employee persistentTomFox = employeeRepository.findOne(id);
    assertThat(persistentTomFox).isNotNull();
    assertThat(persistentTomFox.getId()).isEqualTo(id);
    assertThat(persistentTomFox.getFirstName()).isEqualTo(tomFox.getFirstName());
    assertThat(persistentTomFox.getLastName()).isEqualTo(tomFox.getLastName());
    assertThat(persistentTomFox.getYearlyIncome()).isEqualTo(tomFox.getYearlyIncome());
  }

  @Test
  void test_simple_save() {
    long id = employeeRepository.simpleSave(tomFox);

    Employee persistentTomFox = employeeRepository.findOne(id);
    assertThat(persistentTomFox).isNotNull();
    assertThat(persistentTomFox.getId()).isEqualTo(id);
    assertThat(persistentTomFox.getFirstName()).isEqualTo(tomFox.getFirstName());
    assertThat(persistentTomFox.getLastName()).isEqualTo(tomFox.getLastName());
    assertThat(persistentTomFox.getYearlyIncome()).isEqualTo(tomFox.getYearlyIncome());
  }

  @Test
  void test_update() {
    // Update Mary Jackson
    maryJackson.setFirstName("Mary-Ann");
    maryJackson.setLastName("Black");
    maryJackson.setYearlyIncome(95000);

    employeeRepository.update(maryJackson);

    Employee persistentMaryJackson = employeeRepository.findOne(maryJackson.getId());
    assertThat(persistentMaryJackson).isNotNull();
    assertThat(persistentMaryJackson).isEqualTo(maryJackson);
  }

  @Test
  void test_delete_for_existing_employee() {
    // Create employee, which we can then delete
    long id = employeeRepository.saveAndReturnId(tomFox);

    assertThat(employeeRepository.exists(id)).isTrue();

    boolean deleteResult = employeeRepository.delete(id);

    assertThat(deleteResult).isTrue();
    assertThat(employeeRepository.exists(id)).isFalse();
  }

  @Test
  void test_delete_for_not_existing_employee() {
    boolean result = employeeRepository.delete(-1);

    assertThat(result).isFalse();
  }

}
