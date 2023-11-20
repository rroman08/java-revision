package jUnit;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @org.junit.jupiter.api.Test
    void deposit() {
        BankAccount account = new BankAccount("Roman", "Rudolf", 1_000.00);
        double balance = account.deposit(200.00, true);
        // Uses the equals() method on the BankAccount class
        assertEquals(1200.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        fail("This test has YET to be implemented");
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        BankAccount account = new BankAccount("Roman", "Rudolf", 1_000.00);
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        BankAccount account = new BankAccount("Roman", "Rudolf", 1_000.00);
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }
}
