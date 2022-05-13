package com.fdmgroup.week_two_assessment_employee_api.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.fdmgroup.week_two_assessment_employee_api.exception.EmployeeNotFoundException;
import com.fdmgroup.week_two_assessment_employee_api.model.Employee;
import com.fdmgroup.week_two_assessment_employee_api.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Retrieves all Employees from database.", responses = @ApiResponse(responseCode = "200", description = "Retrieved all Employees from database.", headers = {
            @Header(name = "employee-service", description = "/api/v1/employees") }, content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }))
    @GetMapping({ "", "index", "/" })
    public List<Employee> retrieveEmployees() {
        return employeeService.retrieveUsers();
    }

    @Operation(summary = "Retrieves an Employee from database.", responses = @ApiResponse(responseCode = "200", description = "Retrieved Employee from database.", headers = {
            @Header(name = "employee-service", description = "/api/v1/employees/{id}") }, content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }))
    @GetMapping("/{id}")
    public ResponseEntity<Employee> retrieveEmployee(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        Employee foundEmployee = employeeService.retrieveEmployee(id);
        return ResponseEntity.ok(foundEmployee);
    }

    @Operation(summary = "Creates an Employee and adds them to database.", responses = @ApiResponse(responseCode = "201", description = "Created Employee and add to database.", headers = {
            @Header(name = "employee-service", description = "/api/v1/employees") }, content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }))
    @PostMapping({ "", "index", "/" })
    public ResponseEntity<Employee> createUser(@Valid @RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdEmployee.getId()).toUri();
        return ResponseEntity.created(location).body(createdEmployee);
    }

    @Operation(summary = "Retrieves and Updates an Employee from database.", responses = @ApiResponse(responseCode = "201", description = "Retrieved Employee from database.", headers = {
            @Header(name = "employee-service", description = "/api/v1/employees/{id}") }, content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }))
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable("id") Long id)
            throws EmployeeNotFoundException {
        Employee updatedEmployee = employeeService.updateEmployee(employee, id);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(updatedEmployee.getId()).toUri();
        return ResponseEntity.created(location).body(updatedEmployee);
    }

    @Operation(summary = "Deletes an Employee from database.", responses = @ApiResponse(responseCode = "200", description = "Retrieved Employee from database.", headers = {
            @Header(name = "employee-service", description = "/api/v1/employees/{id}") }, content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }))
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) throws EmployeeNotFoundException {
        employeeService.deleteEmployee(id);
    }

}
