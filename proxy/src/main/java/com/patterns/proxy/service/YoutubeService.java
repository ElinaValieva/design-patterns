package com.patterns.proxy.service;

import java.util.Arrays;
import java.util.List;

public class YoutubeService implements YoutubeInterface {

    private List<String> videos;

    public YoutubeService() {
        this.videos = Arrays.asList("Spring", "Vue", "React", "Angular");
        ;
    }

    @Override
    public List<String> listVideos() {
        return videos;
    }

    @Override
    public String getVideo(Integer id) {
        return videos.get(id);
    }

    @Override
    public void downloadVideo(String video) {
        System.out.println("Downloading ..." + video);
    }
}
