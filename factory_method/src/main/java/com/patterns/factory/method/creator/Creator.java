package com.patterns.factory.method.creator;

import com.patterns.factory.method.model.Transport;

/**
 * @author Elina Valieva on 18.03.2020
 */
public interface Creator {

    void deliverByTransport();

    Transport createTransport();
}
