package com.patterns.mediator;

import com.patterns.mediator.model.Button;
import com.patterns.mediator.model.CheckBox;
import com.patterns.mediator.model.Component;
import com.patterns.mediator.model.TextBox;


/**
 * @author Elina Valieva on 19.03.2020
 */
public class AuthenticationMediator implements Mediator {

    private CheckBox checkBox;

    private Button button;

    private TextBox textBox;


    @Override
    public void notify(Component sender, Component.Event event) {
        sender.setMediator(this);

        if (event == Component.Event.TICK) {
            System.out.println("CheckBox: tick ...");
            checkBox.setMediator(this);
            checkBox.tick();
        }

        if (event == Component.Event.CLICK) {
            System.out.println("Button: click ...");
            button.setMediator(this);
            button.tick();
        }

        if (sender instanceof TextBox && event == Component.Event.KEYPRESS) {
            System.out.println("TextBox: keypress ...");
            textBox.setText("Typing");
            textBox.click();
        }
    }

    @Override
    public void registerComponents(Component component) {
        if (component instanceof TextBox)
            this.textBox = (TextBox) component;
        else this.textBox = new TextBox();

        if (component instanceof CheckBox)
            this.checkBox = (CheckBox) component;
        this.checkBox = new CheckBox();

        if (component instanceof Button)
            this.button = (Button) component;

        else this.button = new Button();
    }
}
