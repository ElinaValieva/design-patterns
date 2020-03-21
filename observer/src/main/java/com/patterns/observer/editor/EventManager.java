package com.patterns.observer.editor;

import com.patterns.observer.listener.EmailListener;
import com.patterns.observer.listener.EventListener;
import com.patterns.observer.listener.LoggingListener;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private List<EventListener> listenerList = new ArrayList<>();

    public void subscribe(EventListener eventListener) {
        listenerList.add(eventListener);
    }

    public void unsubscribe(EventListener eventListener) {
        listenerList.remove(eventListener);
    }

    void notifyAll(String data) {
        listenerList.forEach(eventListener -> eventListener.notify(data));
    }

    void notifyByEmail(String data) {
        listenerList.stream()
                .filter(eventListener -> eventListener instanceof EmailListener)
                .forEach(eventListener -> eventListener.notify(data));
    }

    void notifyByLogging(String data) {
        listenerList.stream()
                .filter(eventListener -> eventListener instanceof LoggingListener)
                .forEach(eventListener -> eventListener.notify(data));
    }
}
