package com.patterns.composite.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class Manager implements Employee {

    private String name;

    private Integer salary;

    private List<Employee> employees;

    public Manager(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
        this.employees = new ArrayList<>();
    }

    @Override
    public String getInfo() {
        String employee = employees.stream()
                                   .map(Employee::getInfo)
                                   .collect(Collectors.joining("\n"));
        return String.format("Manager: %s - [$%s] with employees: \n%s", name, salary, employee);
    }

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void remove(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public Employee getEmployee(int i) {
        return employees.get(i);
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }
}
