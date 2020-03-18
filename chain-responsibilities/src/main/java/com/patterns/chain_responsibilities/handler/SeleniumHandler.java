package com.patterns.chain_responsibilities.handler;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class SeleniumHandler extends BaseHandler {

    @Override
    public void execute() {
        System.out.println("Execute selenium");
        super.execute();
    }
}
