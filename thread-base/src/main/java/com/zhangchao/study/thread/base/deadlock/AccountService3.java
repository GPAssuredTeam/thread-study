package com.zhangchao.study.thread.base.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountService3 implements Runnable{

    private Account from;

    private Account to;

    private Double amount;

    Lock lock = new ReentrantLock();


    public AccountService3(Account from, Account to, Double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void tranfer(){
        while (true) {
            if (lock.tryLock()) {
                if (from.getBalance() < amount) {
                    throw new RuntimeException("余额不足，转账失败");
                }
                from.debit(amount);
                to.credit(amount);
                System.out.println( from.getAccountName() + "->" + from.getBalance()+"  ,"+to.getAccountName()+"->"+to.getBalance());

                lock.unlock();
            }
        }
    }

    @Override
    public void run() {
        tranfer();
    }
}
