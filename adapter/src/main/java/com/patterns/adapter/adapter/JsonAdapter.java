package com.patterns.adapter.adapter;

import com.patterns.adapter.model.JsonModel;
import com.patterns.adapter.model.XmlModel;

public class JsonAdapter {

    public JsonModel adaptXmlToJson(XmlModel xmlModel) {
        String xmlContent = xmlModel.getXmlContent()
                .replace("<format>", "")
                .replace("</format>", "");
        return new JsonModel(String.format("Format { format: %s }", xmlContent));
    }
}
