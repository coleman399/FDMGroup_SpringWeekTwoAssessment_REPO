package com.fdmgroup.week_two_assessment_employee_api.service;

import java.util.List;

import javax.validation.Valid;

import com.fdmgroup.week_two_assessment_employee_api.exception.EmployeeNotFoundException;
import com.fdmgroup.week_two_assessment_employee_api.model.Employee;
import com.fdmgroup.week_two_assessment_employee_api.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> retrieveUsers() {
        return employeeRepository.findAll();
    }

    public Employee retrieveEmployee(Long id) throws EmployeeNotFoundException {
        employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        return employeeRepository.findById(id).get();
    }

    public Employee createEmployee(@Valid Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(@Valid Employee employee, Long id) throws EmployeeNotFoundException {
        employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        Employee oldEmployeeInformation = employeeRepository.findById(id).get();
        oldEmployeeInformation.setFirstName(employee.getFirstName());
        oldEmployeeInformation.setLastName(employee.getLastName());
        oldEmployeeInformation.setSalary(employee.getSalary());
        oldEmployeeInformation.setState(employee.getState());
        oldEmployeeInformation.setCountry(employee.getCountry());
        Employee newEmployeeInformation = oldEmployeeInformation;
        return employeeRepository.save(newEmployeeInformation);
    }

    public void deleteEmployee(Long id) throws EmployeeNotFoundException {
        employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
    }

}
