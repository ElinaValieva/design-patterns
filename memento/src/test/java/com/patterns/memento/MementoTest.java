package com.patterns.memento;

import com.patterns.memento.originator.CareTaker;
import com.patterns.memento.originator.Originator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MementoTest {

    private Originator originator;
    private CareTaker careTaker;

    @Before
    public void setup() {
        originator = new Originator();
        careTaker = new CareTaker(originator);
    }

    @Test
    public void test() {
        String prevState = "first";
        String nextState = "second";

        originator.setState(prevState);
        careTaker.doSomething();
        Assert.assertEquals(prevState, originator.getState());

        originator.setState(nextState);
        careTaker.doSomething();
        Assert.assertEquals(nextState, originator.getState());

        careTaker.undo();
        Assert.assertEquals(prevState, originator.getState());
    }

}
