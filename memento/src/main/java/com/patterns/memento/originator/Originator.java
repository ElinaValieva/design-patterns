package com.patterns.memento.originator;

public class Originator {

    private String state;

    public Originator() {
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    Memento save() {
        return new Memento(state);
    }

    void restore(Memento memento) {
        this.state = memento.getState();
    }
}
