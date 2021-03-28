package com.patterns.message.queue.task;

import com.patterns.message.queue.model.Message;

public interface Task {

    void submit(Message message);
}
