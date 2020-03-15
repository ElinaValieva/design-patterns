package com.patterns.builder;

import com.patterns.builder.model.Hero;

public class Application {

    public static void main(String[] args) {
        Hero hero = Hero.builder()
                .name("Hero")
                .sex(Hero.Sex.MALE)
                .weapon(Hero.Weapon.AXE)
                .armor(Hero.Armor.CHAIN_MAIL)
                .hair(Hero.Hair.BALD)
                .getHero();
        System.out.println("Created hero: " + hero);
    }
}
