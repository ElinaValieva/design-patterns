package com.patterns.value;

import java.util.Objects;

public final class Passport implements Cloneable{

    private Integer number;

    private Integer serialNumber;

    private Type type;

    public enum Type {
        FOREIGN, RUSSIAN
    }

    public Passport(Integer number, Integer serialNumber, Type type) {
        this.number = number;
        this.serialNumber = serialNumber;
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(number, passport.number) &&
                Objects.equals(serialNumber, passport.serialNumber) &&
                type == passport.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, serialNumber, type);
    }
}
