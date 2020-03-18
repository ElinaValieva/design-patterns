package com.patterns.abstract_factory.model.chair;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class VictorianChair implements Chair {

    @Override
    public void getChairInfo() {
        System.out.println("Victorian chair: with 4 legs and victorian sit");
    }
}
