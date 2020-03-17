package com.patterns.visitor.model;

import com.patterns.visitor.visitor.Visitor;

/**
 * @author Elina Valieva on 17.03.2020
 */
public class Circle extends Shape {

    private Integer width;

    public Circle(Integer width) {
        this.width = width;
    }

    public Integer getWidth() {
        return width;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCircle(this);
    }
}
