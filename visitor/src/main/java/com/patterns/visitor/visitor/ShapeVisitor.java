package com.patterns.visitor.visitor;

import com.patterns.visitor.model.Circle;
import com.patterns.visitor.model.Rectangle;

/**
 * @author Elina Valieva on 17.03.2020
 */
public class ShapeVisitor implements Visitor {
    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.println(String.format("Created rectangle: %s %s", rectangle.getHeight(), rectangle.getWidth()));
    }

    @Override
    public void visitCircle(Circle circle) {
        System.out.println(String.format("Created circle: %s", circle.getWidth()));
    }
}
