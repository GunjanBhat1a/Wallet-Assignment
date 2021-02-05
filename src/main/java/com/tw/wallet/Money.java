package com.tw.wallet;

public class Money {
   private final CurrencyType currencyType;
   private final double amount;

    public Money(double amount, CurrencyType currencyType) {
        this.amount = amount;
        this.currencyType = currencyType;
    }

    public Money convertToRupee() {
        return new Money(this.amount * 74.5, CurrencyType.RUPEE);
    }

    public Money convertToDollar() {
        return new Money(this.amount / 74.5, CurrencyType.DOLLAR);
    }

    public Money add(Money money) {
        Money totalAmount;

        if (money.currencyType == CurrencyType.DOLLAR) {
            totalAmount = new Money(this.amount + money.convertToRupee().amount, CurrencyType.RUPEE);
        } else
            totalAmount = new Money(this.amount + money.amount, CurrencyType.RUPEE);
        return totalAmount;

    }
}
