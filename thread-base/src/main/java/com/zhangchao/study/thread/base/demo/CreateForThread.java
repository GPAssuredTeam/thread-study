package com.zhangchao.study.thread.base.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateForThread extends Thread{

    private static  int count ;

    @Override
    public void run() {
        log.info("通过继承Thread创建线程");
        count++;
    }

    public static Integer getCount() {
        return count;
    }
}
