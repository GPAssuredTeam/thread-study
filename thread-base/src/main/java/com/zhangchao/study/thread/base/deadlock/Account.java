package com.zhangchao.study.thread.base.deadlock;

import lombok.Data;

@Data
public class Account {

    private Integer id;

    private String accountName;

    private Double balance;

    public Account(Integer id, String accountName, Double balance) {
        this.id = id;
        this.accountName = accountName;
        this.balance = balance;
    }

    //贷方
    public void credit(double amount){
        balance+=amount;
    }

    //借方
    public void debit(double amount){
        balance-=amount;
    }
}
