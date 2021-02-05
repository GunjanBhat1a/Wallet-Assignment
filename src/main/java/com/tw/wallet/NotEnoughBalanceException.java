package com.tw.wallet;

public class NotEnoughBalanceException extends Throwable {
    public NotEnoughBalanceException(String not_enough_balance) {
        super(not_enough_balance);
    }
}
