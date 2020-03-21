package com.patterns.state.states;

import com.patterns.state.Player;

public class PlayState extends State {

    private Player player;

    public PlayState(Player player) {
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
        player.stopPlaying();
        player.changeState(new ReadyState(player));
    }

    @Override
    public void clickNext() {
        if (player.doubleClick)
            player.fastForward();
        else player.nextSong();
    }

    @Override
    public void clickPrevious() {
        if (player.doubleClick)
            player.rewind();
        else player.previousSong();
    }
}
