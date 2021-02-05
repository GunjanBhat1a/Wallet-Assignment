package com.tw.wallet;


public class Wallet {

    public Money totalMoney;
    public Wallet() {

    }

    public void deposit(Money money) throws NotAValidAmountException {
     if(totalMoney == null)
         totalMoney = money;
     else
        totalMoney = totalMoney.add(money);
    }

    public void withdraw(Money money) throws NotEnoughBalanceException, NotAValidAmountException {
        if(totalMoney == null)
            throw new NotEnoughBalanceException("Not enough balance");
        else
            totalMoney = totalMoney.retrieve(money);
    }
}


