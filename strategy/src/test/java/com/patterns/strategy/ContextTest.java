package com.patterns.strategy;

import com.patterns.strategy.strategy.DivisionStrategy;
import com.patterns.strategy.strategy.MultiplyStrategy;
import com.patterns.strategy.strategy.SubtractStrategy;
import com.patterns.strategy.strategy.SumStrategy;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Elina Valieva on 17.03.2020
 */
public class ContextTest {

    private Context context = new Context();

    @Test
    public void executeSum() {
        context.setStrategy(new SumStrategy());
        Integer result = 10;
        Assert.assertEquals(result, context.execute(2, 8));
    }

    @Test
    public void executeMultiply() {
        context.setStrategy(new MultiplyStrategy());
        Integer result = 16;
        Assert.assertEquals(result, context.execute(2, 8));
    }

    @Test
    public void executeDivision() {
        context.setStrategy(new DivisionStrategy());
        Integer result = 0;
        Assert.assertEquals(result, context.execute(2, 8));
    }

    @Test
    public void executeSubtract() {
        context.setStrategy(new SubtractStrategy());
        Integer result = -6;
        Assert.assertEquals(result, context.execute(2, 8));
    }
}