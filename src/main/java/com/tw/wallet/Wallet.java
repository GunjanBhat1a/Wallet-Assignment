package com.tw.wallet;


public class Wallet {

    public Money totalBalance;
    public Wallet() {
    totalBalance = new Money(0, Currency.RUPEE);
    }

    public void deposit(Money money) throws NotAValidAmountException {

        totalBalance = totalBalance.add(money);
    }

    public void withdraw(Money money) throws NotEnoughBalanceException, NotAValidAmountException {
        if(totalBalance == null)
            throw new NotEnoughBalanceException("Not enough balance");
        else
            totalBalance = totalBalance.retrieve(money);
    }

    public double returnAmountInPreferredCurrency(Currency currency) {
         if(currency == Currency.DOLLAR)
         {
             return this.totalBalance.convertToDollar();
         }
         else {
             return this.totalBalance.amount;
         }
    }
}


