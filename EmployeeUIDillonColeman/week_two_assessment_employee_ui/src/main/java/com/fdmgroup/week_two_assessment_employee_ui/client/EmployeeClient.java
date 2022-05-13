package com.fdmgroup.week_two_assessment_employee_ui.client;

import java.util.List;

import com.fdmgroup.week_two_assessment_employee_ui.model.Employee;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("employee-service")
public interface EmployeeClient {

    @GetMapping("/api/v1/employees")
    List<Employee> retrieveEmployees();

    @GetMapping("/api/v1/employees/{id}")
    Employee retrieveEmployee(@PathVariable("id") Long id);

    @PostMapping("/api/v1/employees")
    Employee createEmployee(@RequestBody Employee employee);

    @PutMapping("/api/v1/employees/{id}")
    Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id);

    @DeleteMapping("/api/v1/employees/{id}")
    void deleteEmployee(@PathVariable("id") Long id);

}
