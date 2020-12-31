package com.zhangchao.study.thread.base.demo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CreateThreadTest {

private static final ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        new Thread(new CreateForThread()).start();
        new Thread(new CreateForRunnable()).start();


        Future<String> future = threadPool.submit(new CreateForCallable());
        String result = future.get();
        System.out.println(result);
    }
}
