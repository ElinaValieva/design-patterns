package com.patterns.visitor.model;

import com.patterns.visitor.visitor.Visitor;

/**
 * @author Elina Valieva on 17.03.2020
 */
public class Rectangle extends Shape {

    private Integer height;

    private Integer width;

    public Rectangle(Integer height, Integer width) {
        this.height = height;
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRectangle(this);
    }
}
