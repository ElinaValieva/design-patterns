package com.patterns.singleton.lazy.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingletonTest {

    @Test
    public void getInstance() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Singleton> submit = null;
        for (int i = 0; i < 2; i++) {
            submit = executorService.submit(Singleton::getInstance);
        }

        System.out.println(submit.get());
        executorService.shutdown();
    }
}