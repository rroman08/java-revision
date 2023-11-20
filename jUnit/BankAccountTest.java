package jUnit;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    // To test order:
    private static int count;

    @org.junit.jupiter.api.BeforeAll
    static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @org.junit.jupiter.api.BeforeEach
    void setup() {
        account = new BankAccount("Roman", "Rudolf", 1_000.00,
                BankAccount.CHECKING);
        System.out.print("Running a test... ");
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(200.00, true);
        // Uses the equals() method on the BankAccount class
        assertEquals(1200.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    // DOES NOT WORK!!! Worked in JUnit4
//    @org.junit.jupiter.api.Test(expected = IllegalArgumentException.class)
//    void withdraw_notBranch() throws Exception {
//        account.withdraw(600.00, false);
//    }

    // EARLIER VERSION WAY OF DOING IT
    @org.junit.jupiter.api.Test
    void withdraw_notBranch() throws Exception {
        try {
            account.withdraw(600.00, false);
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException ignored) {}
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void isChecking_true() {
        assertTrue(account.isChecking(), "The account is NOT a checking account");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDownEach() {
        System.out.println("Count = " + count++);
    }

    @org.junit.jupiter.api.AfterAll
    static void afterClass() {
        System.out.println("This executes after all test cases. Count = " + count++);
    }
}
