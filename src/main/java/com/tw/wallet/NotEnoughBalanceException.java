package com.tw.wallet;

public class NotEnoughBalanceException extends Exception {
    public NotEnoughBalanceException(String notEnoughBalance) {
        super(notEnoughBalance);
    }
}
