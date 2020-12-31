package com.zhangchao.study.thread.base.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CreateForCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        log.info("创建线程通过Callable接口");
        return "SUCCESS";
    }



}
