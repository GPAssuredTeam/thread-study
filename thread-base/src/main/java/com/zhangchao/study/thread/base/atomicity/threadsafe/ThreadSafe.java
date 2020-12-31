package com.zhangchao.study.thread.base.atomicity.threadsafe;

public class ThreadSafe {

    private  static int count ;

    public synchronized static void incr(){
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        count++;
    }
    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            new Thread(()->ThreadSafe.incr()).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
