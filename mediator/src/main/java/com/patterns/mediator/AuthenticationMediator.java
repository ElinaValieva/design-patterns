package com.patterns.mediator;

import com.patterns.mediator.model.Button;
import com.patterns.mediator.model.CheckBox;
import com.patterns.mediator.model.Component;
import com.patterns.mediator.model.TextBox;


/**
 * @author Elina Valieva on 19.03.2020
 */
public class AuthenticationMediator implements Mediator {

    private String title;

    @Override
    public void notify(Component sender, String event) {
        if (sender instanceof CheckBox && event.equals("check")) {
            title = (((CheckBox) sender).getEnabled()) ? "log in" : "register";
        }

        if (sender instanceof Button && event.equals("click")) {
            title = "click";
        }

        if (sender instanceof TextBox && event.equals("keypress")) {
            title = "textBox";
        }
    }

    @Override
    public String getTitle() {
        return title;
    }
}
