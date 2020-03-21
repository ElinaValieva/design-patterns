package com.patterns.memento;

import com.patterns.memento.originator.CareTaker;
import com.patterns.memento.originator.Originator;

public class Application {

    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("1");

        CareTaker careTaker = new CareTaker(originator);
        careTaker.doSomething();

        originator.setState("2");
        careTaker.doSomething();

        careTaker.undo();

        System.out.println(originator.getState());
    }
}
