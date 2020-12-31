package com.zhangchao.study.thread.base.demo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadCircleTest {

    private static boolean flag = true;
    public static void main(String[] args) throws Exception {

        //threadState();

        Thread t1 = new Thread(()->{
            //测试线程停止
            while(flag){

            }
        });
        t1.start();

        flag = false;

      t1.join();

    }



    //测试线程状态
    private static void threadState() {
        new Thread(()->{
            while (true){
            }
        },"t1").start();

        new Thread(()->{
            try {
              Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();

        new Thread(()->{
            try {
                Thread.currentThread().join(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t3").start();

        new Thread(()->{
            while (true) {
                synchronized (ThreadCircleTest.class){
                    try {
                        TimeUnit.SECONDS.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t4").start();

        new Thread(()->{
            while (true) {
                synchronized (ThreadCircleTest.class){
                    try {
                        TimeUnit.SECONDS.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t5").start();

        new Thread(()->{
            while (true){
            }
        },"t1").start();
    }


}
