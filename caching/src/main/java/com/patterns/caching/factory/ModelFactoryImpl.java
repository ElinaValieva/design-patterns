package com.patterns.caching.factory;

import com.patterns.caching.model.BaseModel;
import lombok.SneakyThrows;
import org.bson.Document;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public class ModelFactoryImpl<T extends BaseModel> implements ModelFactory<T> {

    @Override
    @SneakyThrows
    public T create(Document document) {
        Class<T> persistentClass = getClazz();
        Field[] fields = persistentClass.getDeclaredFields();
        T newInstance = persistentClass.newInstance();
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
        Class<T> persistentClass = getClazz();
        Field[] fields = persistentClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            document.append(field.getName(), field.get(entity));
        }
        return document;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getClazz() {
        // todo
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
