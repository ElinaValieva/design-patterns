package com.patterns.adapter.adapter;

import com.patterns.adapter.model.JsonModel;
import com.patterns.adapter.model.XmlModel;

public class XmlAdapter {

    public XmlModel adaptJsonToXml(JsonModel jsonModel) {
        String xmlContent = jsonModel.getJsonContent()
                .replace("Format { format: ", "")
                .replace(" }", "");
        return new XmlModel(String.format("<format>%s</format>", xmlContent));
    }
}
