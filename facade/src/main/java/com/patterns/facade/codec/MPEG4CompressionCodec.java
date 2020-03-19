package com.patterns.facade.codec;

/**
 * @author Elina Valieva on 19.03.2020
 */
public class MPEG4CompressionCodec implements CodecFactory {
    @Override
    public String getCodec() {
        return "MPEG4";
    }
}
