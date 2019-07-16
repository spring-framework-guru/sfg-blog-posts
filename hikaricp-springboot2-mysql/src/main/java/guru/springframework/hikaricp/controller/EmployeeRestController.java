package guru.springframework.hikaricp.controller;

import guru.springframework.hikaricp.domain.Employee;
import guru.springframework.hikaricp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class EmployeeRestController {

//    private EmployeeDAO employeeDAO;
//
//    //inject employee repository  ( quick but dirty)
//    @Autowired
//    public EmployeeRestController(EmployeeDAO emp)
//    {
//        employeeDAO=emp;
//    }
//
//    //expose /employees and return the list of employees
//    @GetMapping("/employees")
//    public List<Employee> findAll()
//    {
//        return employeeDAO.findAll();
//    }


    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService emps)
    {
        employeeService=emps;
    }

    //expose /employees and return the list of employees
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    //add mapping for GET  /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEMployee(@PathVariable int employeeId)
    {
        Employee employee = employeeService.findById(employeeId);

        if(employee == null)
        {
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }
        return employee;
    }

    //add mapping for POST /employees   -add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        //also just in case they pass an id in JSON  ... set id  to 0
        //this is to force a save of new item ... instead of update
        employee.setId(0);
        employeeService.save(employee);
        return employee;

    }

    //add mapping for PUT (update existing employee data) /employees
    @PutMapping("/employees")
    public Employee updateEMployee(@RequestBody Employee employee)
    {
        employeeService.save(employee);
        return employee;
    }

    //delete mapping for DELETE /employees/{employeeId}  -delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee temp = employeeService.findById(employeeId);
        if(temp == null)
        {
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        employeeService.delete(employeeId);
        return "Deleted employee of id - "+employeeId;
    }

}
