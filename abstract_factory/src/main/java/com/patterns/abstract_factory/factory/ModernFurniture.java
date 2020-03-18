package com.patterns.abstract_factory.factory;

import com.patterns.abstract_factory.model.chair.Chair;
import com.patterns.abstract_factory.model.chair.ModernChair;
import com.patterns.abstract_factory.model.sofa.ModernSofa;
import com.patterns.abstract_factory.model.sofa.Sofa;
import com.patterns.abstract_factory.model.table.ModernTable;
import com.patterns.abstract_factory.model.table.Table;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class ModernFurniture implements FurnitureFactory {
    @Override
    public Table createTable() {
        return new ModernTable();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public Chair createChair() {
        return new ModernChair();
    }
}
