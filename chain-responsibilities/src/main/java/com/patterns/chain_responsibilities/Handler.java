package com.patterns.chain_responsibilities;

/**
 * @author Elina Valieva on 18.03.2020
 */
public interface Handler {

    void setHandler(Handler handler);

    void execute();
}
