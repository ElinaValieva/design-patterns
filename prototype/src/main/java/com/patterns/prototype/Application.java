package com.patterns.prototype;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class Application {

    public static void main(String[] args) {
        BasePrototype basePrototype = new BasePrototype("Sam");
        Prototype cloneBasePrototype = basePrototype.clone();
        System.out.println("Compare links = " + (basePrototype == cloneBasePrototype));
        System.out.println("Compare objects = " + basePrototype.equals(cloneBasePrototype));
    }
}
