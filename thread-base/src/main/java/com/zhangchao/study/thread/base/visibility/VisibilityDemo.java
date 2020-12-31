package com.zhangchao.study.thread.base.visibility;

public class VisibilityDemo {
    private static volatile boolean flag = false;
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            int i = 0 ;
            while(!flag){
                i++;
            }
        });
        t1.start();
        Thread.sleep(1000);
        flag = true ;
    }
}
