package com.tw.wallet;

import java.util.List;

public class Dollar extends Currency {

    private double totalAmount;

    public Dollar(Double dollarValue) {
        super(dollarValue);
    }

    @Override
    public double convert(List<Currency> wallet) {
        for (Currency currency : wallet) {
            if (currency instanceof Rupee)
                totalAmount += currency.amount / 74.5;
            else
                totalAmount += currency.amount;
        }
        return totalAmount;
    }
}