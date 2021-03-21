package com.patterns.caching.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.patterns.caching.factory.ModelFactoryImpl;
import com.patterns.caching.model.BaseModel;
import com.patterns.caching.factory.ModelFactory;
import lombok.SneakyThrows;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public class DatabaseManager<T extends BaseModel> implements Database<T> {

    private Map<String, T> dictionary;
    private final ModelFactory<T> modelFactory;
    private MongoDatabase mongoDatabase;
    private boolean useMongo;

    public DatabaseManager(boolean useMongo) {
        this.useMongo = useMongo;
        if (!useMongo)
            createVirtual();
        this.modelFactory = new ModelFactoryImpl<>();
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
            return modelFactory.create(document);
        }
        return dictionary.get(id);
    }

    @Override
    public void update(T entity) {
        if (useMongo) {
            initConnection();
            mongoDatabase.getCollection(DatabaseConstants.TableName).updateOne(new Document("id", entity.getId()), entity.init());
        }
        dictionary.put(entity.getId(), entity);
    }

    @Override
    public void insert(T entity) {
        if (useMongo) {
            initConnection();
            mongoDatabase.getCollection(DatabaseConstants.TableName).insertOne(entity.init());
        }
        dictionary.putIfAbsent(entity.getId(), entity);
    }

    @SneakyThrows
    private void initConnection() {
        if (mongoDatabase == null)
            connect();
    }
}
