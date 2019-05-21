package guru.springframework.jdbctemplate.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings({"SqlResolve", "Unused", "WeakerAccess"})
@Repository
public class EmployeeRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public EmployeeRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   * Checks if an employee for the given id exists in the database.
   * @param id the id of the employee to be checked
   * @return {@code true} if the employee exists, {@code false} otherwise
   */
  public boolean exists(long id) {
    String sqlQuery = "select count(*) from employees where id = ?";

    //noinspection ConstantConditions: return value is always an int, so NPE is impossible here
    int result = jdbcTemplate.queryForObject(sqlQuery, Integer.class, id);

    return result == 1;
  }


  /**
   * Returns the employee for the given id.
   * @param id the id of the employee to be queried
   * @return the employee matching the id or {@code null} if no employee is found
   */
  public Employee findOne(long id) {
    String sqlQuery = "select id, first_name, last_name, yearly_income " +
                      "from employees where id = ?";

    return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToEmployee, id);
  }

  /**
   * Returns a list of all employees that exist in the database.
   * @return a list of all employees
   */
  public List<Employee> findAll() {
    String sqlQuery = "select id, first_name, last_name, yearly_income from employees";

    return jdbcTemplate.query(sqlQuery, this::mapRowToEmployee);
  }

  /**
   * Creates the employee in the database.
   * @param employee the employee to be created
   */
  public void save(Employee employee) {
    String sqlQuery = "insert into employees(first_name, last_name, yearly_income) " +
                      "values (?, ?, ?)";

    jdbcTemplate.update(sqlQuery, employee.getFirstName(), employee.getLastName(), employee.getYearlyIncome());
  }

  /**
   * Creates the employee in the database and returns the id of the created employee.
   * @param employee the employee to be created
   * @return the id of the created employee.
   */
  public long saveAndReturnId(Employee employee) {
    String sqlQuery = "insert into employees(first_name, last_name, yearly_income) " +
                      "values (?, ?, ?)";

    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(connection -> {
      PreparedStatement stmt = connection.prepareStatement(sqlQuery, new String[]{"id"});
      stmt.setString(1, employee.getFirstName());
      stmt.setString(2, employee.getLastName());
      stmt.setLong(3, employee.getYearlyIncome());
      return stmt;
    }, keyHolder);

    return keyHolder.getKey().longValue();
  }


  /**
   * Creates the employee in the database and returns the id of the created employee.
   * The method uses SimpleJdbcInsert instead of JdbcTemplate.
   * @param employee the employee to be created
   * @return the id of the created employee
   */
  public long simpleSave(Employee employee) {
    SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
            .withTableName("employees")
            .usingGeneratedKeyColumns("id");

    return simpleJdbcInsert.executeAndReturnKey(employee.toMap()).longValue();
  }

  /**
   * Updates the employee in the database. The given employee must have a valid id.
   * @param employee the employee to be updated
   */
  public void update(Employee employee) {
    String sqlQuery = "update employees set " +
                      "first_name = ?, last_name = ?, yearly_income = ? " +
                      "where id = ?";

    jdbcTemplate.update(sqlQuery
                      , employee.getFirstName()
                      , employee.getLastName()
                      , employee.getYearlyIncome()
                      , employee.getId());
  }

  /**
   * Deletes the employee for the given id.
   * @param id the id of the employee to be deleted
   * @return {@code true} if the employee could be deleted successfully, {@code false} otherwise
   */
  public boolean delete(long id) {
    String sqlQuery = "delete from employees where id = ?";

    return jdbcTemplate.update(sqlQuery, id) > 0;
  }

  private Employee mapRowToEmployee(ResultSet resultSet, int rowNum) throws SQLException {
    // This method is an implementation of the functional interface RowMapper.
    // It is used to map each row of a ResultSet to an object.
    return Employee.builder()
            .id(resultSet.getLong("id"))
            .firstName(resultSet.getString("first_name"))
            .lastName(resultSet.getString("last_name"))
            .yearlyIncome(resultSet.getLong("yearly_income"))
            .build();
  }

}
