package com.patterns.prototype;

import java.util.Objects;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class BasePrototype implements Prototype {

    private String name;

    BasePrototype(String name) {
        this.name = name;
    }

    @Override
    public Prototype clone() {
        return new BasePrototype(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasePrototype)) return false;
        BasePrototype that = (BasePrototype) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
