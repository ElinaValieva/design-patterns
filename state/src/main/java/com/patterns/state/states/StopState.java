package com.patterns.state.states;

import com.patterns.state.Player;

public class StopState extends State {

    private Player player;

    public StopState(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public void clickLock() {
        if (player.playing)
            player.changeState(new PlayState(player));
        else player.changeState(new ReadyState(player));
    }

    @Override
    public void clickPlay() {
    }

    @Override
    public void clickNext() {
    }

    @Override
    public void clickPrevious() {
    }
}
