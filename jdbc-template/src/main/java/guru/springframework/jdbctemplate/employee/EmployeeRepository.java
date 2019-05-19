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

  public boolean exists(long id) {
    String sqlQuery = "select count(*) from employees where id = ?";

    //noinspection ConstantConditions: return value is always an int, so NPE is impossible here
    int result = jdbcTemplate.queryForObject(sqlQuery, Integer.class, id);

    return result == 1;
  }

  public Employee findOne(long id) {
    String sqlQuery = "select id, first_name, last_name, yearly_income " +
                      "from employees where id = ?";

    return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToEmployee, id);
  }

  public List<Employee> findAll() {
    String sqlQuery = "select id, first_name, last_name, yearly_income from employees";

    return jdbcTemplate.query(sqlQuery, this::mapRowToEmployee);
  }

  public void save(Employee employee) {
    String sqlQuery = "insert into employees(first_name, last_name, yearly_income) " +
                      "values (?, ?, ?)";

    jdbcTemplate.update(sqlQuery, employee.getFirstName(), employee.getLastName(), employee.getYearlyIncome());
  }

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

  public long simpleSave(Employee employee) {
    SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
            .withTableName("employees")
            .usingGeneratedKeyColumns("id");

    return simpleJdbcInsert.executeAndReturnKey(employee.toMap()).longValue();
  }

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
