package com.patterns.state.states;

import com.patterns.state.Player;

public class ReadyState extends State {

    private Player player;

    public ReadyState(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public void clickLock() {
        player.stopPlaying();
        player.changeState(new StopState(player));
    }

    @Override
    public void clickPlay() {
        player.startPlaying();
        player.changeState(new PlayState(player));
    }

    @Override
    public void clickNext() {
        player.nextSong();
    }

    @Override
    public void clickPrevious() {
        player.previousSong();
    }
}
