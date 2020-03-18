package com.patterns.composite.model;

import java.util.List;

/**
 * @author Elina Valieva on 18.03.2020
 */
public interface Employee {

    String getInfo();

    void add(Employee employee);

    void remove(Employee employee);

    Employee getEmployee(int i);

    List<Employee> getEmployees();
}
