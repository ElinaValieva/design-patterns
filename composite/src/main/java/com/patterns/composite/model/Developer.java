package com.patterns.composite.model;

import java.util.List;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class Developer implements Employee {

    private String name;
    private double salary;

    public Developer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        return String.format("Developer %s - [$%s]", name, salary);
    }

    @Override
    public void add(Employee employee) {
        // not supported
    }

    @Override
    public void remove(Employee employee) {
        // not supported
    }

    @Override
    public Employee getEmployee(int i) {
        return null;
    }

    @Override
    public List<Employee> getEmployees() {
        return null;
    }
}
