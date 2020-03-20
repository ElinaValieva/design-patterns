package com.patterns.mediator.model;

/**
 * @author Elina Valieva on 19.03.2020
 */
public class TextBox extends Component {

    private String text;

    public TextBox() {
        super();
    }

    public void setText(String text) {
        this.text = text;
    }
}
