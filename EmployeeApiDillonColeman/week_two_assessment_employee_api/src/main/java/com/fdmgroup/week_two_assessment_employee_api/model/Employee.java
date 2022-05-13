package com.fdmgroup.week_two_assessment_employee_api.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private BigDecimal salary;
    @Column
    private String state;
    @Column
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
