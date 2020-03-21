package com.patterns.memento.originator;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

    private List<Memento> history;
    private Originator originator;

    public CareTaker(Originator originator) {
        this.history = new ArrayList<>();
        this.originator = originator;
    }

    public void doSomething() {
        Memento memento = originator.save();
        history.add(memento);
    }

    public void undo() {
        Memento memento = history.get(history.size() - 2);
        originator.restore(memento);
    }
}
