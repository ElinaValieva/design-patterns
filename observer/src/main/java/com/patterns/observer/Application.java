package com.patterns.observer;

import com.patterns.observer.editor.EventManager;
import com.patterns.observer.editor.FileManager;
import com.patterns.observer.listener.EmailListener;
import com.patterns.observer.listener.LoggingListener;

public class Application {

    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        EmailListener emailListener = new EmailListener();
        LoggingListener loggingListener = new LoggingListener();

        eventManager.subscribe(emailListener);
        eventManager.subscribe(loggingListener);

        FileManager fileManager = new FileManager(eventManager);
        fileManager.createDirectory();
        fileManager.openFile();
        fileManager.saveFile();

        eventManager.unsubscribe(emailListener);
        fileManager.deleteDirectory();
        eventManager.subscribe(emailListener);
        eventManager.unsubscribe(loggingListener);
        fileManager.saveFile();
    }
}
