package com.patterns.abstract_factory.model.table;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class VictorianTable implements Table {
    @Override
    public void getTableInfo() {
        System.out.println("Victorian table");
    }
}
