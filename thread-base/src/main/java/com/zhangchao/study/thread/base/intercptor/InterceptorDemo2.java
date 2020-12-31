package com.zhangchao.study.thread.base.intercptor;

public class InterceptorDemo2 extends Thread{


    private static int i ;
    @Override
    public void run() {
       while (!Thread.currentThread().isInterrupted()){
           try {
               System.out.println("count:"+i++);
               System.out.println(Thread.currentThread().isInterrupted());
               Thread.sleep(100);
           } catch (InterruptedException e) {
            //   Thread.currentThread().interrupt();
           }
       }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterceptorDemo2());
        thread.start();
        Thread.sleep(10);
        thread.interrupt();
    }
}
