package com.patterns.observer.editor;

public class FileManager {

    private EventManager eventManager;

    public FileManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public void openFile() {
        eventManager.notifyAll("Open file");
        eventManager.notifyByEmail("Try to open file");
        eventManager.notifyByLogging("log.debug: Open file");
    }

    public void saveFile() {
        eventManager.notifyAll("Save file");
        eventManager.notifyByEmail("Try to save file");
        eventManager.notifyByLogging("log.debug: Save file");
    }

    public void createDirectory() {
        eventManager.notifyAll("Creation directory");
        eventManager.notifyByEmail("Try to create directory");
        eventManager.notifyByLogging("log.info: Creation directory");
    }

    public void deleteDirectory() {
        eventManager.notifyAll("Deletion directory");
        eventManager.notifyByEmail("Try to delete directory");
        eventManager.notifyByLogging("log.warn: Deletion directory");
    }
}
