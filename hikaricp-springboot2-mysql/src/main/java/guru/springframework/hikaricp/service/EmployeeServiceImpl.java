package guru.springframework.hikaricp.service;

import guru.springframework.hikaricp.repository.EmployeeRepository;
import guru.springframework.hikaricp.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository emp)
    {
        employeeRepository=emp;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result   = employeeRepository.findById(id);

        Employee employee = null;
        if (result.isPresent())
        {
            employee=result.get();
        }
        else{
            //did n't find employee with id
            throw new RuntimeException("Did not find employee of id - "+id);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
