package com.patterns.facade.convector;

import com.patterns.facade.parser.AudioMixer;
import com.patterns.facade.parser.BitrateReader;
import com.patterns.facade.codec.CodecFactory;
import com.patterns.facade.codec.MPEG4CompressionCodec;
import com.patterns.facade.codec.OggCompressionCodec;
import com.patterns.facade.VideoFile;

/**
 * @author Elina Valieva on 19.03.2020
 */
public class Convector implements VideoConvector {

    @Override
    public VideoFile convertVideo(String format) {
        CodecFactory codecFactory = format.equals("mpeg4") ? new MPEG4CompressionCodec() : new OggCompressionCodec();
        String factoryCodec = codecFactory.getCodec();
        String mixedCodec = new AudioMixer().mix(factoryCodec);
        String readedCodec = new BitrateReader().read(mixedCodec);

        return new VideoFile(readedCodec);
    }
}
