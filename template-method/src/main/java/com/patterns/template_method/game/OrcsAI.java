package com.patterns.template_method.game;

/**
 * @author Elina Valieva on 17.03.2020
 */
public class OrcsAI extends GameUI {

    @Override
    void buildStructures() {
        System.out.println("Build structures from OrcsAI");
    }

    @Override
    void buildUnits() {
        System.out.println("Build units from OrcsAI");
    }

    @Override
    void sendWarriors() {
        System.out.println("...");
    }

    @Override
    void sendScouts() {
        System.out.println("Send scouts from OrcsAI");
    }
}
