package com.patterns.proxy;

import com.patterns.proxy.service.ProxyYoutubeService;
import com.patterns.proxy.service.YoutubeInterface;
import com.patterns.proxy.service.YoutubeService;

public class YoutubeManager {

    private YoutubeInterface youtubeInterface;

    public YoutubeManager() {
        this.youtubeInterface = new ProxyYoutubeService(new YoutubeService());
    }

    public void renderVideo() {
        youtubeInterface.listVideos().forEach(video -> youtubeInterface.downloadVideo(video));
    }

    public void renderVideo(Integer id) {
        youtubeInterface.downloadVideo(youtubeInterface.getVideo(id));
    }
}
