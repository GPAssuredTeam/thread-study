package com.zhangchao.study.thread.base.atomicity.threadsafe;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SynchronizedUser {

    //synchronized修饰静态方法,类锁级别,范围太大,性能开销大
    public synchronized static Object toJson(){

        return null;
    }

    //synchronized修饰实例方法,实例锁级别,不同类的实例不互斥
    public synchronized String parseJson(){

        return null;
    }


    //synchronized修饰同步代码块,根据synchronized中变量的类型决定是类锁或者实例锁.
    public  String parseTime(Date date){
        Object obj = new Object();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        synchronized (obj){
            return sdf.format(date);
        }
    }
}
