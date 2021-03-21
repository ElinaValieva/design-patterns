package com.patterns.caching.factory;

import com.patterns.caching.model.User;
import junit.framework.TestCase;
import org.bson.Document;

public class ModelFactoryImplTest extends TestCase {

    public void testCreate() {
        ModelFactory<User> modelFactory = new ModelFactoryImpl<>();
        User entity = new User();
        entity.setId("1");
        entity.setName("Username");
        entity.setDescription("Some description");
        Document document = modelFactory.create(entity);
        assertNotNull(document);
        assertEquals("1", document.getString("id"));
        assertEquals("Username", document.getString("name"));
        assertEquals("Some description", document.getString("description"));
    }

    public void testTestCreate() {
        ModelFactory<User> modelFactory = new ModelFactoryImpl<>();
        Document document = new Document("id", "1").append("name", "Username").append("description", "Some description");
        User user = modelFactory.create(document);
        assertNotNull(user);
        assertEquals("1", user.getId());
        assertEquals("Username", user.getName());
        assertEquals("Some description", user.getDescription());
    }
}