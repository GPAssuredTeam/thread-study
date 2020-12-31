package com.zhangchao.study.thread.base.atomicity.threadsafe;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class MsgTest {

    public static void main(String[] args) throws IOException {
        Queue<String> queue = new LinkedList<>();
        Producer producer = new Producer(queue,5);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
        System.in.read();
    }
}
