package com.patterns.facade;

import com.patterns.facade.convector.Convector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Elina Valieva on 19.03.2020
 */
public class Application {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Set content");
        String content = reader.readLine();

        VideoFile convertVideo = new Convector().convertVideo(content);
        System.out.println(convertVideo.getFile());
    }
}
