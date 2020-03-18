package com.patterns.chain_responsibilities.handler;

import com.patterns.chain_responsibilities.Handler;

/**
 * @author Elina Valieva on 18.03.2020
 */
public class BaseHandler implements Handler {

    private Handler next;

    @Override
    public void setHandler(Handler handler) {
        this.next = handler;
    }

    @Override
    public void execute() {
        if (next != null)
            next.execute();
    }
}
