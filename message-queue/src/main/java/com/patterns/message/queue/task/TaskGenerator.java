package com.patterns.message.queue.task;

import com.patterns.message.queue.model.MessageQueue;
import com.patterns.message.queue.model.Message;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class TaskGenerator implements Task, Runnable {

    private final MessageQueue messageQueue;
    private final int messageCount;

    @Override
    public void submit(Message message) {
        messageQueue.submit(message);
    }

    @Override
    @SneakyThrows
    public void run() {
        int count = messageCount;
        while (count > 0) {
            String messageName = "[" + count + "] - New message submitted from " + Thread.currentThread().getName();
            this.submit(new Message(messageName));
            count--;
            Thread.sleep(1000);
        }
    }
}
