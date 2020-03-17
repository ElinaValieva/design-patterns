package com.patterns.strategy;

import com.patterns.strategy.strategy.DivisionStrategy;
import com.patterns.strategy.strategy.MultiplyStrategy;
import com.patterns.strategy.strategy.SubtractStrategy;
import com.patterns.strategy.strategy.SumStrategy;

/**
 * @author Elina Valieva on 17.03.2020
 */
public class Application {

    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 45;
        Context context = new Context();
        context.setStrategy(new SubtractStrategy());
        Integer result = context.execute(a, b);
        System.out.println(String.format("%s - %s = %s", a, b, result));
        context.setStrategy(new DivisionStrategy());
        result = context.execute(a, b);
        System.out.println(String.format("%s / %s = %s", a, b, result));
        context.setStrategy(new MultiplyStrategy());
        result = context.execute(a, b);
        System.out.println(String.format("%s * %s = %s", a, b, result));
        context.setStrategy(new SumStrategy());
        result = context.execute(a, b);
        System.out.println(String.format("%s + %s = %s", a, b, result));
    }
}
