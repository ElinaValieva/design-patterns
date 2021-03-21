package com.example.caching.cache;

import com.example.caching.model.User;

import java.util.*;

public class LruCache implements Cache {

    private Integer capacity;
    private Map<String, Node> cache = new HashMap<>();
    private Node start;
    private Node end;

    public LruCache(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public User get(String id) {
        if (cache.containsKey(id)) {
            Node node = cache.get(id);
            remove(node);
            changeHead(node);
            return node.user;
        }
        return null;
    }

    @Override
    public void set(String id, User user) {
        if (cache.containsKey(id)) {
            Node node = cache.get(id);
            node.user = user;
            remove(node);
            changeHead(node);
        } else {
            Node node = new Node(id, user);
            if (cache.size() > capacity) {
                cache.remove(end.id);
                remove(end);
            }
            changeHead(node);
            cache.put(id, node);
        }
    }

    @Override
    public boolean contains(String id) {
        return cache.containsKey(id);
    }

    @Override
    public void invalidate(String id) {
        Optional.ofNullable(cache.remove(id)).ifPresent(this::remove);
    }

    @Override
    public boolean isFull() {
        return cache.size() >= capacity;
    }

    @Override
    public User getLru() {
        return end.user;
    }

    @Override
    public void clear() {
        cache.clear();
        end = null;
        start = null;
    }

    @Override
    public void setCapacity(Integer capacity) {
        if (this.capacity >= capacity) {
            clear();
        } else this.capacity = capacity;
    }

    @Override
    public List<User> getCache() {
        List<User> users = new ArrayList<>();
        Node temp = this.start;
        while (temp != null) {
            users.add(temp.user);
            temp = temp.next;
        }

        return users;
    }

    private void changeHead(Node node) {
        node.next = this.start;
        node.previous = null;
        if (this.start != null)
            this.start.previous = node;
        this.start = node;
        if (this.end == null)
            this.end = this.start;
    }

    private void remove(Node node) {
        if (node.previous != null)
            node.previous.next = node.next;
        else this.start = node.next;

        if (node.next != null)
            node.next.previous = node.previous;
        else this.end = node.previous;
    }

    static class Node {
        String id;
        User user;
        Node next;
        Node previous;

        public Node(String id, User user) {
            this.id = id;
            this.user = user;
        }
    }
}
