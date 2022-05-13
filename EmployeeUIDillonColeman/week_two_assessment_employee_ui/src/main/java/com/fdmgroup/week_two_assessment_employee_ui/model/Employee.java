package com.fdmgroup.week_two_assessment_employee_ui.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

public class Employee implements Serializable {

    private long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private BigDecimal salary;
    @NotBlank
    private String state;
    @NotBlank
    private String country;

    public Employee() {
    }

    public Employee(String firstName, String lastName, BigDecimal salary, String state, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.state = state;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Employee [country=" + country + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName
                + ", salary=" + salary + ", state=" + state + "]";
    }

}
