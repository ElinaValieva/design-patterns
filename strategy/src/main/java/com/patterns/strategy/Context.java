package com.patterns.strategy;

import com.patterns.strategy.strategy.Strategy;

import java.util.Comparator;

/**
 * @author Elina Valieva on 17.03.2020
 */
class Context {

    private Strategy strategy;

    void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    Integer execute(Integer a, Integer b) {
        return strategy.execute(a, b);
    }
}
