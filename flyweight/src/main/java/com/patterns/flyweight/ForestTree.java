package com.patterns.flyweight;

import com.patterns.flyweight.flyweight_factory.TreeType;

class ForestTree {

    private int x;

    private int y;

    private TreeType treeType;

    ForestTree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    void draw() {
        System.out.println(String.format("%s %s %s - (%s, %s)", treeType.color, treeType.texture, treeType.name, x, y));
    }
}
