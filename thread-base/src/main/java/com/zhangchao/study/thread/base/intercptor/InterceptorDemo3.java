package com.zhangchao.study.thread.base.intercptor;

public class InterceptorDemo3 extends Thread{

    static  boolean interrupt=false;


    @Override
    public void run() {
        while(!interrupt){
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterceptorDemo3());
        thread.start();
        interrupt=true;
        thread.join();
    }
}
