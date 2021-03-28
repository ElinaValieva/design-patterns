package com.patterns.message.queue.model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessageQueue {

    private final BlockingQueue<Message> blockingQueue;

    public MessageQueue() {
        this.blockingQueue = new ArrayBlockingQueue<>(1024);
    }

    public void submit(Message message) {
        if (message != null)
            blockingQueue.add(message);
    }

    public Message retrieve() {
        if (blockingQueue.isEmpty())
            return null;
        return blockingQueue.poll();
    }
}
