package com.zhangchao.study.thread.base.threadlocal;

public class ThreadJoinTest {


    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程t1执行结束");

        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
