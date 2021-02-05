package com.tw.wallet;

public class NotAValidAmountException extends Exception {
    public NotAValidAmountException(String notAValidAmount) {
        super(notAValidAmount);
    }
}
