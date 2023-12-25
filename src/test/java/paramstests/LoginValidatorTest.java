package test.java.paramstests;

import main.java.LoginValidator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import main.java.LoginValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginValidatorTest {
    LoginValidator loginValidator;
    public static int numberOfTestCases = 0;

    @BeforeAll
    static void setup() {
        System.out.println("==>Test started<==");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("==>Test finished<==");
    }

    @BeforeEach
    void createObjectOfLoginValidator() {
        numberOfTestCases++;
        loginValidator = new LoginValidator();
        System.out.println("Test Case " + numberOfTestCases + " started");
    }

    @AfterEach
    void removeObject() {
        loginValidator = null;
        System.out.println("Test Case " + numberOfTestCases + " finished");
        System.out.println("----------------------");
    }

    @Test
    void TestLoginValidatorWithValidUsername() {
        assertTrue(loginValidator.validateUsername("user@gmail.com"));

    }


    @ParameterizedTest
    @ValueSource(strings = {"usergmail.com", "user@", "usergmail.com", "",})
    void TestLoginValidatorWithInvalidUsernames(String input) {
        assertFalse(loginValidator.validateUsername(input), "Entered Value : " + input +
                " This test case failed!");
    }

    @Test
    void TestLoginValidatorWithNullEmail() {
        assertFalse(loginValidator.validateUsername(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"special1", "special&", "speci1&", "special11111111111@", ""})
    void TestLoginValidatorWithInvalidPasswords(String input) {
        boolean result = loginValidator.validatePassword(input);
        assertFalse(result, "Entered Value : " + input + "\nMethod Rule : Length of Password must be between" +
                "8 and 16 characters \nand it should contains at least one special character and one number\n" +
                "This Test Case failed!");

    }

    @Test
    void TestLoginValidatorWithNullPassword() {
        assertFalse(loginValidator.validatePassword(null));
    }

}
