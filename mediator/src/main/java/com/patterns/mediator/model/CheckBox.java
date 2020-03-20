package com.patterns.mediator.model;

/**
 * @author Elina Valieva on 19.03.2020
 */
public class CheckBox extends Component {

    private boolean enabled;

    public CheckBox() {
        super();
    }

    public void tick() {
        enabled = !enabled;
    }
}
