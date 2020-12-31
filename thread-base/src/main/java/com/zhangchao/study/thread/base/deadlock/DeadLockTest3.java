package com.zhangchao.study.thread.base.deadlock;

public class DeadLockTest3 {

    public static void main(String[] args) {
        Account from = new Account(1,"tom",100000.0);
        Account to = new Account(2,"mic",100000.0);
        Allocate allocate = new Allocate();
        new Thread(new AccountService3(from,to,10.0)).start();
        new Thread(new AccountService3(to,from,20.0)).start();

    }
}
