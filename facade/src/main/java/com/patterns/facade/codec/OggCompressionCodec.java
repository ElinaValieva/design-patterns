package com.patterns.facade.codec;

/**
 * @author Elina Valieva on 19.03.2020
 */
public class OggCompressionCodec implements CodecFactory {

    @Override
    public String getCodec() {
        return "OGG";
    }
}
