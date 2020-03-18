package com.patterns.abstract_factory.model.table;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class ModernTable implements Table {
    @Override
    public void getTableInfo() {
        System.out.println("Modern table");
    }
}
