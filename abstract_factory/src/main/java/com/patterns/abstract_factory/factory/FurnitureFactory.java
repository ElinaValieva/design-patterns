package com.patterns.abstract_factory.factory;

import com.patterns.abstract_factory.model.chair.Chair;
import com.patterns.abstract_factory.model.sofa.Sofa;
import com.patterns.abstract_factory.model.table.Table;

/**
 * @author Elina Valieva on 18.03.2020
 */
public interface FurnitureFactory {

    Table createTable();

    Sofa createSofa();

    Chair createChair();
}
