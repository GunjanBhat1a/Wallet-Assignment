package com.tw.wallet;


public class Wallet {

    public Money totalMoney;
    public Wallet() {
     totalMoney = new Money(0.0, CurrencyType.RUPEE);
    }

    public void deposit(Money money) throws NotAValidAmountException {
        totalMoney = totalMoney.add(money);
    }

}


