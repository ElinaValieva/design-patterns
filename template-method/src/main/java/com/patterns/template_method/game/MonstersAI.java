package com.patterns.template_method.game;

/**
 * @author Elina Valieva on 17.03.2020
 */
public class MonstersAI extends GameUI {

    @Override
    void buildStructures() {
        System.out.println("Build structures from MonstersAI");
    }

    @Override
    void buildUnits() {
        System.out.println("...");
    }

    @Override
    void sendWarriors() {
        System.out.println("Send warriors from MonstersAI");

    }

    @Override
    void sendScouts() {
        System.out.println("...");
    }
}
