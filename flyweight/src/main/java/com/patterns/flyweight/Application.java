package com.patterns.flyweight;

import com.patterns.flyweight.flyweight_factory.TreeType;
import com.patterns.flyweight.flyweight_factory.TreeTypeFactory;

import java.awt.*;

public class Application {

    public static void main(String[] args) {
        TreeTypeFactory treeTypeFactory = new TreeTypeFactory();
        Forest forest = new Forest(treeTypeFactory);
        forest.plantTree(10, 112, "Spruce", Color.green, TreeType.Texture.coniferous);
        forest.plantTree(10, 120, "Oak", Color.green, TreeType.Texture.hardwood);
        forest.plantTree(110, 12, "Spruce", Color.green, TreeType.Texture.coniferous);
        forest.plantTree(100, 12, "Oak", Color.green, TreeType.Texture.hardwood);

        forest.draw();
    }
}
