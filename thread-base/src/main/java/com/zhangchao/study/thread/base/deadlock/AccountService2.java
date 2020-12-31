package com.zhangchao.study.thread.base.deadlock;

public class AccountService2 implements Runnable{

    private Account from;

    private Account to;

    private Double amount;

    private Allocate allocate;

    public AccountService2(Account from, Account to, Double amount, Allocate allocate) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.allocate = allocate;
    }

    public void tranfer(){
        while (true) {
            if(allocate.apply(from,to)) {
                try {
                    synchronized (from) {
                        synchronized (to) {
                            if (from.getBalance() < amount) {
                                throw new RuntimeException("余额不足，转账失败");
                            }
                            from.debit(amount);
                            to.credit(amount);
                            System.out.println( from.getAccountName() + "->" + from.getBalance()+"  ,"+to.getAccountName()+"->"+to.getBalance());
                        }
                    }
                }finally {
                    allocate.release(from,to);
                }
            }
        }
    }

    @Override
    public void run() {
        tranfer();
    }
}
