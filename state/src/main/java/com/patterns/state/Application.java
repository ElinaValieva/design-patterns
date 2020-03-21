package com.patterns.state;

public class Application {

    public static void main(String[] args) {
        Player player = new Player();
        player.clickPlay();
        player.clickNext(false);
        player.clickNext(true);
        player.clickPrevious(false);
        player.clickPrevious(true);
        player.clickLock();
    }
}
