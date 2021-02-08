package com.tw.wallet;

import java.util.Objects;

public class Money {
    final Currency currency;
    final double amount;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money add(Money money) throws NotAValidAmountException {
        if (money.amount <= 0 || this.amount < 0) throw new NotAValidAmountException("Not a valid amount");

        Money totalAmount;

        if (this.currency != money.currency) {
            totalAmount = new Money(this.amount + this.currency.convertTo(money), this.currency);
        } else
            totalAmount = new Money(this.amount + money.amount, this.currency);

        return totalAmount;

    }

    public Money retrieve(Money money) throws NotAValidAmountException, NotEnoughBalanceException {
        if (money.amount <= 0) throw new NotAValidAmountException("Not a valid amount");

        if (this.currency != money.currency) {
            double convertedMoney = this.currency.convertTo(money);
            if (this.amount < convertedMoney)
                throw new NotEnoughBalanceException("Not Enough Balance");
            else
                return new Money(this.amount - convertedMoney, this.currency);
        } else
            return new Money(this.amount - money.amount, this.currency);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return this.amount == money.amount && this.currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }


}
