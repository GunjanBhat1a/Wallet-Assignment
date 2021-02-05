package com.tw.wallet;

import java.util.List;

public class Rupee extends Currency {

    private double totalAmount;

    public Rupee(Double rupeeValue) {
        super(rupeeValue);
    }

    @Override
    public double convert(List<Currency> wallet) {
        for (Currency currency : wallet) {
            if (currency instanceof Dollar)
                totalAmount += currency.amount * 74.5;
            else
                totalAmount += currency.amount;
        }
        return totalAmount;
    }
}