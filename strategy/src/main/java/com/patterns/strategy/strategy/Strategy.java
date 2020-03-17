package com.patterns.strategy.strategy;

/**
 * @author Elina Valieva on 17.03.2020
 */
public interface Strategy {

    <T extends Number> int execute(T a, T b);
}
