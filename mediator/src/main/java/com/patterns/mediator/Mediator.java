package com.patterns.mediator;

import com.patterns.mediator.model.Component;

/**
 * @author Elina Valieva on 19.03.2020
 */
public interface Mediator {

    void notify(Component sender, Component.Event event);

    void registerComponents(Component component);
}
