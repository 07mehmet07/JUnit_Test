package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.java.BankAccount;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    BankAccount bankAccount = new BankAccount();

    /*
    this test case is for Use Case Testing
     */

    @Test
    void testDepositIntoAccount() {
        bankAccount.deposit(200.0);
        assertEquals(bankAccount.getBalance(), 200.0);
    }

    @Test
    void testWithdrowFromAccountWithSufficientFunds() {
        bankAccount.deposit(200.0);
        bankAccount.withdraw(100);
        assertEquals(bankAccount.getBalance(), 100);

    }

    @Test
    void testWithdrowFromAccountWExceedingBalance() {
        bankAccount.deposit(200);
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(200.1);
        });
    }

    @Test
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(-121);
        });
    }

    @Test
    void testWithdrowNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(-675);
        });
    }
}
