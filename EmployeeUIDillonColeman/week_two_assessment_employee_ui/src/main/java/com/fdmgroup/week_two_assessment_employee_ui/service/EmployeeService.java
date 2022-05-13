package com.fdmgroup.week_two_assessment_employee_ui.service;

import java.util.List;

import com.fdmgroup.week_two_assessment_employee_ui.client.EmployeeClient;
import com.fdmgroup.week_two_assessment_employee_ui.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeClient employeeClient;

    @Autowired
    public EmployeeService(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    public List<Employee> retrieveEmployees() {
        return employeeClient.retrieveEmployees();
    }
    
    public Employee retrieveEmployee(Long id) {
        return employeeClient.retrieveEmployee(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeClient.createEmployee(employee);
    }

    public Employee updateEmployee(Employee employee, Long id) {
        return employeeClient.updateEmployee(employee, id);
    }

    public void deleteEmployee(Long id) {
        employeeClient.deleteEmployee(id);
    }

}
