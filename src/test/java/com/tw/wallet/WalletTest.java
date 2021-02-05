package com.tw.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {

    @Test
    void shouldNotThrowExceptionForPuttingMoneyInWallet() {
        Rupee amount = new Rupee(30.0);
        Dollar amount1 = new Dollar(2.0);

        Wallet wallet = new Wallet();

        assertDoesNotThrow(() -> wallet.add(amount));
        assertDoesNotThrow(() -> wallet.add(amount1));
    }

    @Test
    void shouldThrowExceptionIfValidAmountIsNotAdded() {
        Rupee amount = new Rupee(-17.0);
        Dollar amount1 = new Dollar((double) 0);

        Wallet wallet = new Wallet();

        assertThrows(NotAValidAmountException.class, () -> wallet.add(amount));
        assertThrows(NotAValidAmountException.class, () -> wallet.add(amount1));
    }
}
