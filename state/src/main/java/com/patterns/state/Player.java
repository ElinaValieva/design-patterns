package com.patterns.state;

import com.patterns.state.states.ReadyState;
import com.patterns.state.states.State;

public class Player {

    public boolean playing;
    public boolean doubleClick;
    private State state;

    public Player() {
        this.state = new ReadyState(this);
        this.playing = false;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void clickLock() {
        state.clickLock();
        playing = false;
    }

    public void clickPlay() {
        state.clickPlay();
        playing = true;
    }

    public void clickNext(boolean doubleClick) {
        this.doubleClick = doubleClick;
        state.clickNext();
    }

    public void clickPrevious(boolean doubleClick) {
        this.doubleClick = doubleClick;
        state.clickPrevious();
    }

    public void startPlaying() {
        playing = true;
        System.out.println("Start playing");
    }

    public void stopPlaying() {
        playing = false;
        System.out.println("Stop playing");
    }

    public void nextSong() {
        doubleClick = false;
        System.out.println("Next");
    }

    public void previousSong() {
        doubleClick = false;
        System.out.println("Prev");
    }

    public void fastForward() {
        doubleClick = true;
        System.out.println("Next->Next->Next");
    }

    public void rewind() {
        doubleClick = true;
        System.out.println("Prev->Prev->Prev");
    }
}
