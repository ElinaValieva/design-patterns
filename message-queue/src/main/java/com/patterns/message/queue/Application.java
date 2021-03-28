package com.patterns.message.queue;

import com.patterns.message.queue.executor.ServiceExecutor;
import com.patterns.message.queue.model.MessageQueue;
import com.patterns.message.queue.task.TaskGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Application {

    private static final Logger logger = Logger.getLogger(Application.class.getSimpleName());

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        MessageQueue messageQueue = new MessageQueue();
        List<TaskGenerator> tasks = Arrays.asList(
                new TaskGenerator(messageQueue, 5),
                new TaskGenerator(messageQueue, 1),
                new TaskGenerator(messageQueue, 2));
        ServiceExecutor serviceExecutor = new ServiceExecutor(messageQueue);
        tasks.forEach(executorService::submit);
        executorService.submit(serviceExecutor);
        logger.info("Initiating shutdown."
                + " Executor will shutdown only after all the Threads are completed.");
        executorService.shutdown();
    }
}
