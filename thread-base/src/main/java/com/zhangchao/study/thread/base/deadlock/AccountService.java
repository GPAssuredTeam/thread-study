package com.zhangchao.study.thread.base.deadlock;

public class AccountService implements Runnable{

    private Account from;

    private Account to;

    private Double amount;

    public AccountService(Account from, Account to, Double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void tranfer(){
        while (true) {
            synchronized (from) {
                synchronized (to) {
                    if(from.getBalance()<amount){
                        throw new RuntimeException("余额不足，转账失败");
                    }
                    from.debit(amount);
                    to.credit(amount);
                    System.out.println("账户:"+from.getAccountName()+"->"+from.getBalance());
                }
            }
        }
    }

    @Override
    public void run() {
        tranfer();
    }
}
