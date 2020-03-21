package com.patterns.state.states;

import com.patterns.state.Player;

public abstract class State {

    private Player player;

    public State(Player player) {
        this.player = player;
    }

    public abstract void clickLock();

    public abstract void clickPlay();

    public abstract void clickNext();

    public abstract void clickPrevious();
}
