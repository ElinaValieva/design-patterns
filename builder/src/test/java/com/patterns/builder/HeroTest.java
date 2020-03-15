package com.patterns.builder;

import com.patterns.builder.model.Hero;
import org.junit.Assert;
import org.junit.Test;

public class HeroTest {

    private static final String HERO = "Hero";
    private static final Hero.Sex MALE = Hero.Sex.MALE;
    private static final Hero.Weapon AXE = Hero.Weapon.AXE;
    private static final Hero.Armor CHAIN_MAIL = Hero.Armor.CHAIN_MAIL;
    private static final Hero.Hair BALD = Hero.Hair.BALD;

    @Test
    public void test() {
        Hero hero = Hero.builder()
                .name(HERO)
                .sex(MALE)
                .weapon(AXE)
                .armor(CHAIN_MAIL)
                .hair(BALD)
                .getHero();
        Assert.assertEquals(HERO, hero.getName());
        Assert.assertEquals(MALE, hero.getSex());
        Assert.assertEquals(AXE, hero.getWeapon());
        Assert.assertEquals(CHAIN_MAIL, hero.getArmor());
        Assert.assertEquals(BALD, hero.getHair());
    }
}
