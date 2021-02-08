package com.tw.wallet;

public enum Currency {
    RUPEE(1.0), DOLLAR(74.5);
    public final double conversionFactor;

    Currency(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double convertTo(Money money) {

        if (this == RUPEE)
            return money.amount * DOLLAR.conversionFactor;
        else
            return money.amount / DOLLAR.conversionFactor;

    }
}
