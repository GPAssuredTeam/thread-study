package com.zhangchao.study.thread.base.atomicity.threadsafe;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{

    private Queue<String> queue;

    public Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            synchronized (queue){
                if(queue.isEmpty()){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费消息:"+queue.remove());
                queue.notify();
            }
        }
    }

    private void shutdown(){
        Thread.currentThread().interrupt();
    }
}
