package com.patterns.adapter;

import com.patterns.adapter.adapter.JsonAdapter;
import com.patterns.adapter.adapter.XmlAdapter;
import com.patterns.adapter.model.JsonModel;
import com.patterns.adapter.model.XmlModel;
import com.patterns.adapter.provider.JsonProvider;
import com.patterns.adapter.provider.XmlProvider;
import org.junit.Assert;
import org.junit.Test;

public class FormatTest {

    @Test
    public void test() {
        JsonModel jsonModel = new JsonModel("Format { format: adapter }");
        XmlModel xmlModel = new XmlModel("<format>adapter</format>");
        Assert.assertEquals(xmlModel.getXmlContent(), getXmlFromJson(jsonModel));
        Assert.assertEquals(jsonModel.getJsonContent(), getJsonFromXml(xmlModel));
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
