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

    public Money add(Money money) throws NotAValidAmountException {
        if (money.amount <= 0) throw new NotAValidAmountException("Not a valid amount");
        Money totalAmount;

        if (money.currencyType == CurrencyType.DOLLAR) {
            totalAmount = new Money(this.amount + money.convertToRupee().amount, this.currencyType);
        } else
            totalAmount = new Money(this.amount + money.amount, this.currencyType);
        return totalAmount;

    }

    public Money retrieve(Money money) throws NotAValidAmountException, NotEnoughBalanceException {
        if (money.amount <= 0) throw new NotAValidAmountException("Not a valid amount");

        if (money.currencyType == CurrencyType.DOLLAR) {
            Money moneyInRupees = money.convertToRupee();
            if (this.amount < moneyInRupees.amount)
                throw new NotEnoughBalanceException("Not Enough Balance");
            else
                return new Money(this.amount - moneyInRupees.amount, this.currencyType);
        } else
            return new Money(this.amount - money.amount, this.currencyType);

    }
}
