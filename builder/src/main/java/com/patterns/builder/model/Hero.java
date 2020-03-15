package com.patterns.builder.model;

public class Hero {

    private String name;

    private Sex sex;

    private Hair hair;

    private Weapon weapon;

    private Armor armor;

    public enum Sex {
        MALE, FEMALE
    }

    public enum Hair {
        BLOND, BLACK, BALD
    }

    public enum Weapon {
        DAGGER, SWORD, AXE, WARMER, BOW
    }

    public enum Armor {
        CLOTHES, LEATHER, CHAIN_MAIL, PLATE_MAIL
    }

    @Override
    public String toString() {
        return "Hero " +
                "name=" + name +
                ", sex=" + sex.name() +
                ", hair=" + hair.name() +
                ", weapon=" + weapon.name() +
                ", armor=" + armor.name();
    }

    void setName(String name) {
        this.name = name;
    }

    void setSex(Sex sex) {
        this.sex = sex;
    }

    void setHair(Hair hair) {
        this.hair = hair;
    }

    void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public Hair getHair() {
        return hair;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public static Builder builder() {
        return new Builder();
    }
}
