package com.zhangchao.study.thread.base.atomicity.threadsafe;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{


    private Queue<String> queue;

    private int maxSize;

    public Producer(Queue<String> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }
    //生产消息,并通知消费者消费,如果消息生产满了,阻塞,等待消费者消费后唤醒
    @Override
    public void run() {

        int count = 0;

        //不停生产
        while (!Thread.currentThread().isInterrupted()){
            synchronized (queue){
                if(queue.size()==maxSize){
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
                count = count + 1;
                queue.add(""+count);
                queue.notify();
                System.out.println("生产者生产消息:"+count);
            }



        }
    }

    private void shutdown(){
        Thread.currentThread().interrupt();
    }
}
