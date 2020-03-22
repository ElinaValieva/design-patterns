package com.patterns.proxy.service;

import java.util.List;

public interface YoutubeInterface {

    List<String> listVideos();

    String getVideo(Integer id);

    void downloadVideo(String video);
}
