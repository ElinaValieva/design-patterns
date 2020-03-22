package com.patterns.proxy;

public class Application {

    public static void main(String[] args) {
        YoutubeManager youtubeManager = new YoutubeManager();
        youtubeManager.renderVideo();
        youtubeManager.renderVideo(0);

        youtubeManager.renderVideo();
    }
}
