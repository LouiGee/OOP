package com.ratify.EmployeeDetail;

import com.ratify.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private com.ratify.Repository.EmployeeRepository EmployeeRepository;

    public List<Employee> getAllEmployee() {
        return EmployeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return EmployeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return EmployeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        EmployeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Employee employee) {return EmployeeRepository.save(employee);}
}
