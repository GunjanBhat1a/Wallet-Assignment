package com.tw.wallet;

public class Money {
    final Currency currency;
    final double amount;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double convertToRupee() {
        return this.amount * 74.5;
    }

    public double convertToDollar() {
        return this.amount / 74.5;
    }

    public Money add(Money money) throws NotAValidAmountException {
        if (money.amount <= 0) throw new NotAValidAmountException("Not a valid amount");
        Money totalAmount;

        if (money.currency == Currency.DOLLAR) {
            totalAmount = new Money(this.amount + money.convertToRupee(), this.currency);
        } else
            totalAmount = new Money(this.amount + money.amount, this.currency);
        return totalAmount;

    }

    public Money retrieve(Money money) throws NotAValidAmountException, NotEnoughBalanceException {
        if (money.amount <= 0) throw new NotAValidAmountException("Not a valid amount");

        if (money.currency == Currency.DOLLAR) {
           double moneyInRupees = money.convertToRupee();
            if (this.amount < moneyInRupees)
                throw new NotEnoughBalanceException("Not Enough Balance");
            else
                return new Money(this.amount - moneyInRupees, this.currency);
        } else
            return new Money(this.amount - money.amount, this.currency);

    }
}
