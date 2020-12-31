package com.zhangchao.study.thread.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

    private final static StampedLock lock = new StampedLock();
    private final static Lock readLock = lock.asReadLock();
    private final static Lock writeLock = lock.asWriteLock();


    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            ReentrantWriteLoadlockTest.write();
        }).start();
        Thread.sleep(1);
        new Thread(()->{
            ReentrantWriteLoadlockTest.read();
        }).start();
        Thread.sleep(1);
        new Thread(()->{
            ReentrantWriteLoadlockTest.read();
        }).start();
    }

    public static void write(){
        writeLock.lock();
        try {
            System.out.println("写入value..");
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static Object read(){
        readLock.lock();
        try {
            System.out.println("读取value..");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return new Object();
    }
}
