package com.patterns.visitor.model;

import com.patterns.visitor.visitor.Visitor;

/**
 * @author Elina Valieva on 17.03.2020
 */
public abstract class Shape {

    public abstract void accept(Visitor visitor);

}
