package com.patterns.flyweight.flyweight_factory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TreeTypeFactory {

    private List<TreeType> treeTypes;

    public TreeTypeFactory() {
        this.treeTypes = new ArrayList<>();
    }

    public TreeType getTreeType(String name, Color color, TreeType.Texture texture) {
        TreeType foundedTreeType = treeTypes.stream()
                .filter(treeType -> treeType.name.equals(name))
                .filter(treeType -> treeType.texture.equals(texture))
                .filter(treeType -> treeType.color.equals(color))
                .findFirst().orElse(null);

        if (foundedTreeType == null) {
            TreeType treeType = new TreeType(name, color, texture);
            treeTypes.add(treeType);
            return treeType;
        }
        return foundedTreeType;
    }
}
