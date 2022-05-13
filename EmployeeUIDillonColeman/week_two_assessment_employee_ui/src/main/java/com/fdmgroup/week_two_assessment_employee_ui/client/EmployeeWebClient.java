package com.fdmgroup.week_two_assessment_employee_ui.client;

import java.util.List;

import com.fdmgroup.week_two_assessment_employee_ui.model.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

public class EmployeeWebClient implements EmployeeClient {

    private static final String URI_EXT = "/api/v1/employees";
    private WebClient webClient;

    public EmployeeWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<Employee> retrieveEmployees() {
        return webClient.get().uri(builder -> builder.path(URI_EXT).build()).retrieve().bodyToFlux(Employee.class)
                .collectList().block();
    }
    
    @Override
    public Employee retrieveEmployee(Long id) {
        return webClient.get().uri(builder -> builder.path("/api/v1/employees/{id}").build(id)).retrieve()
                .onStatus(HttpStatus.NOT_FOUND::equals, ClientResponse::createException).bodyToMono(Employee.class)
                .block();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return webClient.post().uri(builder -> builder.path(URI_EXT).build()).bodyValue(employee).retrieve()
                .bodyToMono(Employee.class).block();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        return webClient.put().uri(builder -> builder.path("/api/v1/employees/{id}").build(id)).bodyValue(employee)
                .retrieve().bodyToMono(Employee.class).block();
    }

    @Override
    public void deleteEmployee(Long id) {
        webClient.delete().uri(builder -> builder.path(URI_EXT + "/{id}").build(id)).retrieve()
                .toBodilessEntity().block();
    }

}
