package com.patterns.mediator;

import com.patterns.mediator.model.TextBox;

/**
 * @author Elina Valieva on 19.03.2020
 */
public class Application {

    public static void main(String[] args) {
        Mediator mediator = new AuthenticationMediator();
        mediator.notify(new TextBox(mediator), "click");

        System.out.println(mediator.getTitle());
    }
}
