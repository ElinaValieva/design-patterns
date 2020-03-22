package com.patterns.flyweight.flyweight_factory;

import java.awt.*;

public class TreeType {

    public String name;

    public Color color;

    public Texture texture;

    public TreeType(String name, Color color, Texture texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public enum Texture {
        coniferous, hardwood
    }
}
