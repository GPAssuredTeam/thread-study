package com.zhangchao.study.thread.base.threadlocal;

public class ThreadLocalTest {

//    private volatile static int num = 0 ;

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 0;
        }
    };
    public static void main(String[] args) {
         new Thread(()->{
                int num = threadLocal.get();
                threadLocal.set(num+=5);
                threadLocal.set(num+=8);

             System.out.println(Thread.currentThread().getName()+"->"+num);

         }).start();

    }
}
