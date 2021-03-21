package com.patterns.caching.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.patterns.caching.factory.ModelFactoryCreator;
import com.patterns.caching.model.BaseModel;
import com.patterns.caching.factory.ModelFactory;
import lombok.SneakyThrows;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public class DatabaseManager<T extends BaseModel> implements Database<T> {

    private Map<String, T> dictionary;
    private final Class<T> clazz;
    private final ModelFactory<T> modelFactory;
    private MongoDatabase mongoDatabase;
    private boolean useMongo;

    public DatabaseManager(Class<T> clazz, boolean useMongo) {
        this.clazz = clazz;
        this.useMongo = useMongo;
        if (!useMongo)
            createVirtual();
        this.modelFactory = new ModelFactoryCreator<>();
    }

    private void createVirtual() {
        this.useMongo = false;
        dictionary = new HashMap<>();
    }

    public void connect() {
        this.useMongo = true;
        MongoClient mongoClient = new MongoClient();
        mongoDatabase = mongoClient.getDatabase("test");
    }

    @Override
    public T selectById(String id) {
        if (useMongo) {
            initConnection();
            Document document = mongoDatabase
                    .getCollection(DatabaseConstants.TableName)
                    .find(new Document("id", id))
                    .first();
            return modelFactory.create(document, clazz);
        }
        return dictionary.get(id);
    }

    @Override
    public void update(T entity) {
        if (useMongo) {
            initConnection();
            mongoDatabase.getCollection(DatabaseConstants.TableName).updateOne(new Document("id", entity.getId()), modelFactory.create(entity));
        }
        dictionary.put(entity.getId(), entity);
    }

    @Override
    public void insert(T entity) {
        if (useMongo) {
            initConnection();
            mongoDatabase.getCollection(DatabaseConstants.TableName).insertOne(modelFactory.create(entity));
        }
        dictionary.putIfAbsent(entity.getId(), entity);
    }

    @SneakyThrows
    private void initConnection() {
        if (mongoDatabase == null)
            connect();
    }
}
