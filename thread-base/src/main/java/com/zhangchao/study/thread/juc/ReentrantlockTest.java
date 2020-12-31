package com.zhangchao.study.thread.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 互斥锁测试，如何保证原子性
 */
public class ReentrantlockTest {

    final static Lock lock = new ReentrantLock();

    static int count = 0;

    public static void main(String[] args) {

        //模拟1000个线程count++ ，不加锁导致原子性问题
            for (int i = 0; i < 1000; i++) {
                new Thread(() -> {
                    lock.lock();
                    try {
                        Thread.sleep(1);
                        count++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }

                }).start();
            }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
