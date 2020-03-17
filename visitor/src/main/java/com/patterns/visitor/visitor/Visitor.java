package com.patterns.visitor.visitor;

import com.patterns.visitor.model.Circle;
import com.patterns.visitor.model.Rectangle;

/**
 * @author Elina Valieva on 17.03.2020
 */
public interface Visitor {

    void visitRectangle(Rectangle rectangle);

    void visitCircle(Circle circle);
}
