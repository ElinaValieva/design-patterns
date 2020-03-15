package com.patterns.adapter.provider;

import com.patterns.adapter.model.JsonModel;

public class JsonProvider {

    public String getJsonContent(JsonModel jsonModel) {
        return jsonModel.getJsonContent();
    }
}
