package com.zhangchao.study.thread.base.intercptor;

public class InterceptorDemo extends Thread{


    private static int i ;
    @Override
    public void run() {
       while (!Thread.currentThread().isInterrupted()){
           System.out.println("count:"+i++);
           System.out.println(Thread.currentThread().isInterrupted());
       }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterceptorDemo());
        thread.start();
        Thread.sleep(10);
        thread.interrupt();
    }
}
