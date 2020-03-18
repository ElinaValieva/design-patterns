package com.patterns.abstract_factory.model.chair;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class ModernChair implements Chair {
    @Override
    public void getChairInfo() {
        System.out.println("Modern chair without legs and with modern sit");
    }
}
