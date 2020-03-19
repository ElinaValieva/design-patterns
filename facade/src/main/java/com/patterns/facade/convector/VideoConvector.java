package com.patterns.facade.convector;

import com.patterns.facade.VideoFile;

/**
 * @author Elina Valieva on 19.03.2020
 */
public interface VideoConvector {

    VideoFile convertVideo(String format);
}
