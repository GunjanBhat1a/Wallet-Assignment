package com.tw.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {

    @Test
    void shouldNotThrowExceptionForPuttingValidAmountInWallet() {
        Money fiftyRupee = new Money(50, CurrencyType.RUPEE);
        Money twoDollar = new Money(2, CurrencyType.DOLLAR);

        Wallet wallet = new Wallet();

        assertDoesNotThrow(() -> wallet.deposit(fiftyRupee));
        assertDoesNotThrow(() -> wallet.deposit(twoDollar));

    }

    @Test
    void shouldThrowExceptionForPuttingInValidAmountInWallet() throws NotAValidAmountException {
        Money fiftyRupee = new Money(-50, CurrencyType.RUPEE);
        Money oneDollar = new Money(1, CurrencyType.DOLLAR);

        Wallet wallet = new Wallet();
        wallet.deposit(oneDollar);


        assertThrows(NotAValidAmountException.class, () -> wallet.deposit(fiftyRupee));
    }

    @Test
    void shouldNotThrowExceptionIfValidAmountIsRetrieved() throws NotAValidAmountException {
        Money hundredRupee = new Money(100, CurrencyType.RUPEE);
        Money oneDollar = new Money(1, CurrencyType.DOLLAR);

        Wallet wallet = new Wallet();
        wallet.deposit(hundredRupee);

        assertDoesNotThrow(() -> wallet.withdraw(oneDollar));
    }

    @Test
    void shouldThrowExceptionIfInValidAmountIsRetrieved() throws NotAValidAmountException {
        Money hundredRupee = new Money(-100, CurrencyType.RUPEE);
        Money oneDollar = new Money(1, CurrencyType.DOLLAR);

        Wallet wallet = new Wallet();
        wallet.deposit(oneDollar);

        assertThrows(NotAValidAmountException.class, () -> wallet.withdraw(hundredRupee));
    }

@Test
    void shouldThrowExceptionIfAmountRetrievedIsLargerThanAvailable() throws NotAValidAmountException {
           Money fiftyRupee = new Money(50, CurrencyType.RUPEE);
           Money twoDollar = new Money(2, CurrencyType.DOLLAR);

            Wallet wallet = new Wallet();
            wallet.deposit(fiftyRupee);

            assertThrows(NotEnoughBalanceException.class, () -> wallet.withdraw(twoDollar));
        }
}
