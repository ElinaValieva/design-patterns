package com.patterns.caching.factory;

import com.patterns.caching.model.BaseModel;
import org.bson.Document;

public class ModelFactoryImpl<T extends BaseModel> implements ModelFactory<T> {

    @Override
    public T create(Document document) {
        // todo
        return null;
    }
}
