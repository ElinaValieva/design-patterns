package com.patterns.caching.cache;

import com.patterns.caching.model.BaseModel;

import java.util.*;

public class LruCache<T extends BaseModel> implements Cache<T> {

    private Integer capacity;
    private final Map<String, Node<T>> cache = new HashMap<>();
    private Node<T> start;
    private Node<T> end;

    public LruCache(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public T get(String id) {
        if (cache.containsKey(id)) {
            Node<T> node = cache.get(id);
            remove(node);
            changeHead(node);
            return node.value;
        }
        return null;
    }

    @Override
    public void set(String id, T value) {
        if (cache.containsKey(id)) {
            Node<T> node = cache.get(id);
            node.value = value;
            remove(node);
            changeHead(node);
        } else {
            Node<T> node = new Node<>(id, value);
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
    public T getLru() {
        return end.value;
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
    public List<T> getCache() {
        List<T> users = new ArrayList<>();
        Node<T> temp = this.start;
        while (temp != null) {
            users.add(temp.value);
            temp = temp.next;
        }

        return users;
    }

    private void changeHead(Node<T> node) {
        node.next = this.start;
        node.previous = null;
        if (this.start != null)
            this.start.previous = node;
        this.start = node;
        if (this.end == null)
            this.end = this.start;
    }

    private void remove(Node<T> node) {
        if (node.previous != null)
            node.previous.next = node.next;
        else this.start = node.next;

        if (node.next != null)
            node.next.previous = node.previous;
        else this.end = node.previous;
    }

    static class Node<T> {
        String id;
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(String id, T value) {
            this.id = id;
            this.value = value;
        }
    }
}
