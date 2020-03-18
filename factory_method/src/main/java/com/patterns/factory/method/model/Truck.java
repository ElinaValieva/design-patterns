package com.patterns.factory.method.model;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("Deliver by Truck");
    }
}
