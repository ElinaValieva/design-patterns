package com.patterns.caching.factory;


import com.patterns.caching.model.BaseModel;
import org.bson.Document;

public interface ModelFactory<T extends BaseModel> {

    T create(Document document, Class<T> tClass);

    Document create(T entity);
}
