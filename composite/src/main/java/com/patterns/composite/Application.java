package com.patterns.composite;

import com.patterns.composite.model.Developer;
import com.patterns.composite.model.Employee;
import com.patterns.composite.model.Manager;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class Application {

    public static void main(String[] args) {
        Developer marry = new Developer("Marry", 3000);
        Employee manager = new Manager("Daniel", 12000);
        manager.add(new Developer("Mike", 1000));
        manager.add(new Developer("David", 2000));
        manager.add(marry);

        Employee generalManager = new Manager("Vladimir", 50000);
        generalManager.add(manager);
        System.out.println(generalManager.getInfo());

        manager.remove(marry);
        System.out.println(generalManager.getInfo());
    }
}
