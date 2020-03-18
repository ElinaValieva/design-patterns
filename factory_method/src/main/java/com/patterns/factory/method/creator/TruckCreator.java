package com.patterns.factory.method.creator;

import com.patterns.factory.method.model.Transport;
import com.patterns.factory.method.model.Truck;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class TruckCreator implements Creator {

    @Override
    public void deliverByTransport() {
        createTransport().deliver();
    }

    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
