package com.patterns.chain_responsibilities;

import com.patterns.chain_responsibilities.handler.RestHandler;
import com.patterns.chain_responsibilities.handler.SeleniumHandler;
import com.patterns.chain_responsibilities.handler.SoapHandler;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class Application {

    public static void main(String[] args) {
        Handler mainHandler = new RestHandler();
        SoapHandler soapHandler = new SoapHandler();
        mainHandler.setHandler(soapHandler);
        soapHandler.setHandler(new SeleniumHandler());

        mainHandler.execute();
    }
}
