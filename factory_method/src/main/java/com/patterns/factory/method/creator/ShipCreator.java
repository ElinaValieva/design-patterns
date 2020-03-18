package com.patterns.factory.method.creator;

import com.patterns.factory.method.model.Ship;
import com.patterns.factory.method.model.Transport;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class ShipCreator implements Creator {

    @Override
    public void deliverByTransport() {
        createTransport().deliver();
    }

    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
