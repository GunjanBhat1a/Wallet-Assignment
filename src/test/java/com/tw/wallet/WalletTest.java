package com.tw.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {

    @Test
    void shouldNotThrowExceptionForPuttingValidAmountInWallet() {
        Money fiftyRupee = new Money(50, Currency.RUPEE);
        Money twoDollar = new Money(2, Currency.DOLLAR);

        Wallet wallet = new Wallet();

        assertDoesNotThrow(() -> wallet.deposit(fiftyRupee));
        assertDoesNotThrow(() -> wallet.deposit(twoDollar));

    }

    @Test
    void shouldThrowExceptionForPuttingInValidAmountInWallet() throws NotAValidAmountException {
        Money fiftyRupee = new Money(-50, Currency.RUPEE);
        Money oneDollar = new Money(1, Currency.DOLLAR);

        Wallet wallet = new Wallet();
        wallet.deposit(oneDollar);


        assertThrows(NotAValidAmountException.class, () -> wallet.deposit(fiftyRupee));
    }

    @Test
    void shouldNotThrowExceptionIfValidAmountIsRetrieved() throws NotAValidAmountException {
        Money hundredRupee = new Money(100, Currency.RUPEE);
        Money oneDollar = new Money(1, Currency.DOLLAR);

        Wallet wallet = new Wallet();
        wallet.deposit(hundredRupee);

        assertDoesNotThrow(() -> wallet.withdraw(oneDollar));
    }

    @Test
    void shouldThrowExceptionIfInValidAmountIsRetrieved() throws NotAValidAmountException {
        Money hundredRupee = new Money(-100, Currency.RUPEE);
        Money oneDollar = new Money(1, Currency.DOLLAR);

        Wallet wallet = new Wallet();
        wallet.deposit(oneDollar);

        assertThrows(NotAValidAmountException.class, () -> wallet.withdraw(hundredRupee));
    }

    @Test
    void shouldThrowExceptionIfAmountRetrievedIsLargerThanAvailable() throws NotAValidAmountException {
        Money fiftyRupee = new Money(50, Currency.RUPEE);
        Money twoDollar = new Money(2, Currency.DOLLAR);

        Wallet wallet = new Wallet();
        wallet.deposit(fiftyRupee);

        assertThrows(NotEnoughBalanceException.class, () -> wallet.withdraw(twoDollar));
    }

    @Test
    void shouldReturnWalletMoneyInPreferredAmount() throws NotAValidAmountException, NotEnoughBalanceException {
        Money oneDollar = new Money(1, Currency.DOLLAR);
        Money twoDollar = new Money(2, Currency.DOLLAR);
        Money fiftyRupee = new Money(50, Currency.RUPEE);

        Wallet wallet = new Wallet();

        wallet.deposit(oneDollar);
        wallet.deposit(twoDollar);
        wallet.deposit(fiftyRupee);

        assertEquals(273.5, wallet.returnAmountInPreferredCurrency(Currency.RUPEE), 0.0000000001);
        assertEquals(3.6711409395973154, wallet.returnAmountInPreferredCurrency(Currency.DOLLAR), 0.0000000001);
    }
}

