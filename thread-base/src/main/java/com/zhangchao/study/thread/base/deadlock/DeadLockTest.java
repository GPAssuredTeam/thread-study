package com.zhangchao.study.thread.base.deadlock;

public class DeadLockTest {

    public static void main(String[] args) {
        Account from = new Account(1,"tom",100000.0);
        Account to = new Account(2,"mic",100000.0);

        new Thread(new AccountService(from,to,10.0)).start();
        new Thread(new AccountService(to,from,10.0)).start();

    }
}
