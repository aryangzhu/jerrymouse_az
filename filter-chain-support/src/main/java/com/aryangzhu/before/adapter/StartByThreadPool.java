package com.aryangzhu.before.adapter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StartByThreadPool {

    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            MyTask<Long> objectMyTask = new MyTask<>(10L);
            Future<Long> future = executorService.submit(objectMyTask);
            Long result = future.get();
            System.out.println("main thread done,result:"+result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
