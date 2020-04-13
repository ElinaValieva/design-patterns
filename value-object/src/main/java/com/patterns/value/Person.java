package com.patterns.value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Person {

    private final String name;

    private final Integer age;

    private final List<Passport> passports;

    public Person(String name, Integer age, List<Passport> passports) {
        this.name = name;
        this.age = age;
        this.passports = Collections.unmodifiableList(passports);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List<Passport> getPassports() {
        return new ArrayList<>(passports);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age) &&
                Objects.equals(passports, person.passports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, passports);
    }
}
