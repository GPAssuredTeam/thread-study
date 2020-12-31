package com.zhangchao.study.thread.base.atomicity.threadsafe;


import org.openjdk.jol.info.ClassLayout;


public class SynchronizedUpdate {



    public static void main(String[] args) {

        SynchronizedUpdate synchronizedUpdate = new SynchronizedUpdate();

        //线程锁的升级
        new Thread(()->{
            synchronized (synchronizedUpdate){
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (synchronizedUpdate){

            System.out.println("synchronizedUpdate is Locking... ");
            System.out.println(ClassLayout.parseInstance(synchronizedUpdate).toPrintable());

        }

    }
}
