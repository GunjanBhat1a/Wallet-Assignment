package com.tw.wallet;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private final List<Currency> wallet = new ArrayList<>();
    private double totalAmount;


    public Wallet() {
        this.totalAmount = 0;
    }

    public void add(Currency currency) throws NotAValidAmountException {
        if (currency.amount <= 0) throw new NotAValidAmountException("Not A Valid Amount");

       wallet.add(currency);
    }

}


