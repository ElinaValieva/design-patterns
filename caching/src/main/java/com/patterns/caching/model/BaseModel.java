package com.patterns.caching.model;

import lombok.Data;
import org.bson.Document;

@Data
public class BaseModel {

    private String id;

    public BaseModel init(Document document) {
        this.id = document.getString("id");
        return new BaseModel();
    }

    public Document init() {
        return new Document("id", id);
    }
}
