package com.patterns.mediator.model;

import com.patterns.mediator.Mediator;

/**
 * @author Elina Valieva on 19.03.2020
 */
public class CheckBox extends Component {

    private Mediator mediator;

    private boolean enabled;

    public CheckBox(Mediator mediator) {
        super(mediator);
    }

    public boolean isEnabled() {
        return enabled;
    }

    void check() {
        mediator.notify(this, "check");
    }
}
