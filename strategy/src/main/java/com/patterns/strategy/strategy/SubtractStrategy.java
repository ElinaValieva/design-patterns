package com.patterns.strategy.strategy;

/**
 * @author Elina Valieva on 17.03.2020
 */
public class SubtractStrategy implements Strategy {

    @Override
    public <T extends Number> int execute(T a, T b) {
        return a.intValue() - b.intValue();
    }
}
