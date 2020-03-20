package com.patterns.mediator;

import com.patterns.mediator.model.Component;
import com.patterns.mediator.model.TextBox;

/**
 * @author Elina Valieva on 19.03.2020
 */
public class Application {

    public static void main(String[] args) {
        Mediator mediator = new AuthenticationMediator();
        TextBox sender = new TextBox();
        mediator.registerComponents(sender);
        mediator.notify(sender, Component.Event.KEYPRESS);
    }
}
