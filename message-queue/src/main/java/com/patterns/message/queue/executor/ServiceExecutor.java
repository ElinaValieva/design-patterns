package com.patterns.message.queue.executor;

import com.patterns.message.queue.model.Message;
import com.patterns.message.queue.model.MessageQueue;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class ServiceExecutor implements Runnable {

    private final MessageQueue queue;

    @Override
    @SneakyThrows
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Message message = queue.retrieve();
            if (message == null)
                System.out.println("Waiting for messages");
            else System.out.println("Poll message" + message);
            Thread.sleep(1000);
        }
    }
}
