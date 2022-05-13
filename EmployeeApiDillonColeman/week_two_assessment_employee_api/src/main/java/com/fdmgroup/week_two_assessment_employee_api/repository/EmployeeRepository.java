package com.fdmgroup.week_two_assessment_employee_api.repository;

import com.fdmgroup.week_two_assessment_employee_api.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
