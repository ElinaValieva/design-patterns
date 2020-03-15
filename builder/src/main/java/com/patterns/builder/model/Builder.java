package com.patterns.builder.model;

public class Builder {

    private Hero hero;

    Builder() {
        hero = new Hero();
    }

    public Builder name(String name) {
        hero.setName(name);
        return this;
    }

    public Builder sex(Hero.Sex sex) {
        hero.setSex(sex);
        return this;
    }

    public Builder hair(Hero.Hair hair) {
        hero.setHair(hair);
        return this;
    }

    public Builder weapon(Hero.Weapon weapon) {
        hero.setWeapon(weapon);
        return this;
    }

    public Builder armor(Hero.Armor armor) {
        hero.setArmor(armor);
        return this;
    }

    public Hero getHero() {
        return hero;
    }
}
