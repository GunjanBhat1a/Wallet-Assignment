package com.tw.wallet;


public class Wallet {

    public Money money;


    public void deposit(Money money) throws NotAValidAmountException {
        if (this.money == null)
            this.money = money;
        else
            this.money = this.money.add(money);
    }

    public void withdraw(Money money) throws NotEnoughBalanceException, NotAValidAmountException {
        if (this.money == null)
            throw new NotEnoughBalanceException("Not enough balance");
        else
            this.money = this.money.retrieve(money);
    }

    public double returnAmountInPreferredCurrency(Currency currency) throws NotEnoughBalanceException {

        if (this.money == null)
            throw new NotEnoughBalanceException("Not enough Balance");

        if (money.currency != currency)
            return currency.convertTo(money);
        else
            return money.amount;

    }
}


