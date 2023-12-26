package test.java.paramstests;

import main.java.BankAccount2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount2 bankAccount;
    public static int numberOfTestCases = 0;

    @BeforeEach
    void startTestCases() {
        numberOfTestCases++;
        System.out.println("Test case" + numberOfTestCases + " started!");
        bankAccount = new BankAccount2(100);
    }

    @BeforeAll
    static void setUp() {
        System.out.println("==>Test STARTED!<==");
    }

    @AfterEach
    void finishTestCases() {
        System.out.println("Test case" + numberOfTestCases + " finished!");

    }

    @AfterAll
    static void tearDown() {
        System.out.println("==>Test FINISHED!<==");
    }


    @Test
    void testDepositToBankAccount() {
        double balance = bankAccount.getBalance();
        bankAccount.deposit(50);
        assertEquals(150, bankAccount.getBalance(), "Deposit input : 50" +
                "\nMethod Rule : currentBalance = " + balance + " + input" +
                "\nTC_01 Failed!!");

    }


    @Test
    void testWithdrawWithSufficientAmountFromBankAccount() {
        double balance = bankAccount.getBalance();
        bankAccount.withdraw(50);
        assertEquals(50, bankAccount.getBalance(), "Withdraw input : 50" +
                "\nMethod Rule : currentBalance = " + balance + " - input" +
                "\nTC_02 Failed!!");

    }

    @Test
    void testWithdrawFromAccountExceedingBalance() {
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(120);
        });

    }

    @Test
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(-1);
        });

    }

    @Test
    void testWithdrawNegativeAmount() {
        bankAccount.deposit(3);
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(-1);
        });


    }

    @Test
    void testTransactionHistory() {
        bankAccount.deposit(100);
        assertEquals("Deposited: $100.0", bankAccount.getAccountHistory());
    }
}
