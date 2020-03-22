package com.patterns.flyweight;

import com.patterns.flyweight.flyweight_factory.TreeType;
import com.patterns.flyweight.flyweight_factory.TreeTypeFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Forest {

    private List<ForestTree> forestTrees;
    private TreeTypeFactory treeTypeFactory;

    Forest(TreeTypeFactory treeTypeFactory) {
        forestTrees = new ArrayList<>();
        this.treeTypeFactory = treeTypeFactory;
    }

    void plantTree(int x, int y, String name, Color color, TreeType.Texture texture) {
        TreeType treeType = treeTypeFactory.getTreeType(name, color, texture);
        forestTrees.add(new ForestTree(x, y, treeType));
    }

    void draw() {
        forestTrees.forEach(ForestTree::draw);
    }
}
