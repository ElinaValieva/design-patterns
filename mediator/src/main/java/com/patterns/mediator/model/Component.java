package com.patterns.mediator.model;

import com.patterns.mediator.Mediator;

/**
 * @author Elina Valieva on 19.03.2020
 */
public class Component {

    private Mediator mediator;

    Component() {
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void click() {
        mediator.notify(this, Event.CLICK);
    }

    public void keypress() {
        mediator.notify(this, Event.KEYPRESS);
    }

    public void tick() {
        mediator.notify(this, Event.TICK);
    }

    public enum Event {
        CLICK, KEYPRESS, TICK
    }
}
