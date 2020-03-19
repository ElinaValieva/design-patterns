package com.patterns.mediator.model;

import com.patterns.mediator.Mediator;

/**
 * @author Elina Valieva on 19.03.2020
 */
public class Component {

    private Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }

    void click() {
        mediator.notify(this, "click");
    }

    void keypress() {
        mediator.notify(this, "keypress");
    }
}
