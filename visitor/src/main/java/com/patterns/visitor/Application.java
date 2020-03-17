package com.patterns.visitor;

import com.patterns.visitor.model.Circle;
import com.patterns.visitor.model.Rectangle;
import com.patterns.visitor.model.Shape;
import com.patterns.visitor.visitor.ShapeVisitor;
import com.patterns.visitor.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elina Valieva on 17.03.2020
 */
public class Application {

    public static void main(String[] args) {
        List<Shape> shapes = generateShapes();
        Visitor visitor = new ShapeVisitor();
        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
    }

    private static List<Shape> generateShapes() {
        List<Shape> shapes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Integer width = Math.toIntExact(Math.round(Math.random() + 100));
            Integer height = Math.toIntExact(Math.round(Math.random() + 100));
            if (width > height)
                shapes.add(new Circle(width));
            else shapes.add(new Rectangle(width, height));
        }

        return shapes;
    }
}
