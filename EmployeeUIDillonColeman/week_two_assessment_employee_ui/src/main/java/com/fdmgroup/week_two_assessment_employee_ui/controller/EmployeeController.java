package com.fdmgroup.week_two_assessment_employee_ui.controller;

import java.util.List;

import com.fdmgroup.week_two_assessment_employee_ui.model.Employee;
import com.fdmgroup.week_two_assessment_employee_ui.service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({ "", "index", "/" })
    public String goToIndex(Model model) {
        List<Employee> employees = employeeService.retrieveEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("displayEmployee/{id}")
    public String goToEmployeePage(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.retrieveEmployee(id);
        model.addAttribute("employee", employee);
        return "display-employee";
    }

    @GetMapping("/createEmployee")
    public String goToCreateEmployeePage(Model model) {
        model.addAttribute("employee", new Employee());
        return "create-employee";
    }

    @PostMapping("/createEmployee")
    public String createEmployee(Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/updateEmployee/{id}")
    public String goToUpdateEmployeePage(@PathVariable("id") Long id, Model model) {
        Employee foundEmployee = employeeService.retrieveEmployee(id);
        model.addAttribute("employee", foundEmployee);
        return "update-employee";
    }

    @PostMapping("/updateEmployee/{id}")
    public String updateUser(@PathVariable("id") Long id, Employee employee) {
        employeeService.updateEmployee(employee, id);
        return "redirect:/";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
