package com.patterns.abstract_factory.factory;

import com.patterns.abstract_factory.model.chair.Chair;
import com.patterns.abstract_factory.model.chair.VictorianChair;
import com.patterns.abstract_factory.model.sofa.Sofa;
import com.patterns.abstract_factory.model.sofa.VictorianSofa;
import com.patterns.abstract_factory.model.table.Table;
import com.patterns.abstract_factory.model.table.VictorianTable;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class VictorianFurniture implements FurnitureFactory {
    @Override
    public Table createTable() {
        return new VictorianTable();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }
}
