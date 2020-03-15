package com.patterns.adapter;

import com.patterns.adapter.adapter.JsonAdapter;
import com.patterns.adapter.adapter.XmlAdapter;
import com.patterns.adapter.model.JsonModel;
import com.patterns.adapter.model.XmlModel;
import com.patterns.adapter.provider.JsonProvider;
import com.patterns.adapter.provider.XmlProvider;

public class Application {

    public static void main(String[] args) {
        JsonModel jsonModel = new JsonModel("Format { format: adapter }");
        String xmlModelContent = getXmlFromJson(jsonModel);
        System.out.println("Convert from json:" + jsonModel.getJsonContent() + " to xml: " + xmlModelContent);

        XmlModel xmlModel = new XmlModel("<format>adapter</format>");
        System.out.println("Convert from xml: " + xmlModel.getXmlContent() + " to json: " + getJsonFromXml(xmlModel));
    }

    private static String getJsonFromXml(XmlModel xmlModel) {
        JsonAdapter jsonAdapter = new JsonAdapter();
        JsonProvider jsonProvider = new JsonProvider();
        return jsonProvider.getJsonContent(jsonAdapter.adaptXmlToJson(xmlModel));
    }

    private static String getXmlFromJson(JsonModel jsonModel) {
        XmlProvider xmlProvider = new XmlProvider();
        XmlAdapter xmlAdapter = new XmlAdapter();
        return xmlProvider.getXmlModelContent(xmlAdapter.adaptJsonToXml(jsonModel));
    }
}
