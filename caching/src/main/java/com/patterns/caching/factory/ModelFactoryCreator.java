package com.patterns.caching.factory;

import com.patterns.caching.model.BaseModel;
import lombok.SneakyThrows;
import org.bson.Document;

import java.lang.reflect.Field;

public class ModelFactoryCreator<T extends BaseModel> implements ModelFactory<T> {

    @Override
    @SneakyThrows
    public T create(Document document, Class<T> tClass) {
        Field[] fields = tClass.getDeclaredFields();
        T newInstance = tClass.newInstance();
        newInstance.setId(document.getString("id"));
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(newInstance, document.get(field.getName()));
        }
        return newInstance;
    }

    @SneakyThrows
    @Override
    public Document create(T entity) {
        Document document = new Document("id", entity.getId());
        Class<T> persistentClass = getClazz(entity);
        Field[] fields = persistentClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            document.append(field.getName(), field.get(entity));
        }
        return document;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getClazz(T entity) {
        return (Class<T>) entity.getClass();
    }
}
