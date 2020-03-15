package com.patterns.adapter.provider;

import com.patterns.adapter.model.XmlModel;

public class XmlProvider {

    public String getXmlModelContent(XmlModel xmlModel) {
        return xmlModel.getXmlContent();
    }
}
