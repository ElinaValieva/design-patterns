package com.patterns.proxy.service;

import java.util.ArrayList;
import java.util.List;

public class ProxyYoutubeService implements YoutubeInterface {

    private YoutubeService youtubeService;
    private List<String> cachedList;
    private boolean cached;

    public ProxyYoutubeService(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
        this.cachedList = new ArrayList<>();
    }

    @Override
    public List<String> listVideos() {
        if (cachedList == null || cachedList.isEmpty()) {
            this.cachedList = youtubeService.listVideos();
        }
        return cachedList;
    }

    @Override
    public String getVideo(Integer id) {
        if (cachedList == null || cachedList.isEmpty()) {
            return youtubeService.getVideo(id);
        }
        return cachedList.get(id);
    }

    @Override
    public void downloadVideo(String video) {
        if (cached)
            System.out.println("Cached .. " + video);
        else {
            youtubeService.downloadVideo(video);
            cached = true;
        }
    }
}
