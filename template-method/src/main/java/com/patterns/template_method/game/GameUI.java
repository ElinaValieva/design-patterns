package com.patterns.template_method.game;

/**
 * @author Elina Valieva on 17.03.2020
 */
public abstract class GameUI {

    public void turn() {
        collectResources();
        buildStructures();
        buildUnits();
        attack();
    }

    private void collectResources() {
        System.out.println("Start collecting resources");
    }

    abstract void buildStructures();

    abstract void buildUnits();

    private void attack() {
        sendScouts();
        sendWarriors();
    }

    abstract void sendWarriors();

    abstract void sendScouts();
}
