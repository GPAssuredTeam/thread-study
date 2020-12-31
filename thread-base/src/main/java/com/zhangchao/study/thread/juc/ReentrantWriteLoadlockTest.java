package com.zhangchao.study.thread.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 测试读写锁，读之间不互斥
 */
public class ReentrantWriteLoadlockTest {

    final static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    final static Lock readLock = readWriteLock.readLock();
    final static Lock writeLock = readWriteLock.writeLock();

    static int count = 0;

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
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return new Object();
    }
}
