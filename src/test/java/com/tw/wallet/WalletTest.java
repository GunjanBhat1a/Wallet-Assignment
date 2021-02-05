package com.tw.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WalletTest {

    @Test
    void shouldNotThrowExceptionForPuttingValidAmountInWallet() {
        Money fiftyRupee = new Money(50, CurrencyType.RUPEE);
        Money twoDollar = new Money(2, CurrencyType.DOLLAR);

        Wallet wallet = new Wallet();

        assertDoesNotThrow(() -> wallet.deposit(fiftyRupee));
        assertDoesNotThrow(() -> wallet.deposit(twoDollar));

    }
}