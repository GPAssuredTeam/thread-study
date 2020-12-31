package com.zhangchao.study.thread.base.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateForRunnable implements Runnable{

    private static int count ;

    @Override
    public void run() {
        count++;
        log.info("通过实现Runnable接口创建线程");
    }
}
