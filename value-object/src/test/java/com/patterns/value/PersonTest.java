package com.patterns.value;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonTest {

    @Test
    public void test() {
        List<Passport> passports = Arrays.asList(new Passport(123, 11, Passport.Type.RUSSIAN),
                new Passport(144, 1111, Passport.Type.FOREIGN));
        Person person = new Person("Bob", 12, passports);
        List<Passport> personPassports = person.getPassports();
        person.getPassports().remove(0);
        person.getPassports().add(new Passport(111, 111, Passport.Type.RUSSIAN));
        passports = new ArrayList<>();
        passports.add(new Passport(11, 145, Passport.Type.RUSSIAN));
        Assert.assertEquals(personPassports, person.getPassports());
        Assert.assertNotEquals(passports, person.getPassports());
    }
}