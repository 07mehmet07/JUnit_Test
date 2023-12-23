package test.java;


import main.java.LoginValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginValidatorTest {
    LoginValidator loginValidator = new LoginValidator();

    // this test is for validating username

    @Test
    void validEmailAdressWithValidateUsername() {
        boolean result = loginValidator.validateUsername("3007toprak@gmail.com");
        assertTrue(result);
    }

    @Test
    void emailWithoutAtSymbol() {
        boolean result = loginValidator.validateUsername("3007toprakgmail.com");
        assertFalse(result);
    }

    @Test
    void emailWithoutDomain() {
        boolean result = loginValidator.validateUsername("3007toprak@");
        assertFalse(result);
    }

    @Test
    void emailWithoInvalidCharecters() {
        boolean result = loginValidator.validateUsername("3007toprak_)&@gmail.com");
        assertFalse(result);
    }

    @Test
    void emptyEmailString() {
        boolean result = loginValidator.validateUsername("");
        assertFalse(result);
    }

    @Test
    void nullEmailAdress() {
        boolean result = loginValidator.validateUsername(null);
        assertFalse(result);
    }

    //this test is for validating password
    /*
     Validates if the provided password is between 8-16 characters, contains at least one number and one special character.
Params:
password – the password to validate
Returns:
true if the password meets the criteria, false otherwi
        */

    @Test
    void validPasswordForValidatePasswordMetdod() {
        boolean result = loginValidator.validatePassword("meh1234&");
        assertTrue(result);
    }

    @Test
    void passwordWithoutSpeacialCharacter() {
        boolean result = loginValidator.validatePassword("meh1234");
        assertFalse(result);
    }

    @Test
    void passwordWithoutNumber() {
        boolean result = loginValidator.validatePassword("meh&");
        assertFalse(result);
    }

    @Test
    void passwordWTooShort() {
        boolean result = loginValidator.validatePassword("meh123&");
        assertFalse(result);
    }

    @Test
    void passwordWTooLong() {
        boolean result = loginValidator.validatePassword("meh1234567890987&");
        assertFalse(result);
    }

    @Test
    void emptyPasswordString() {
        boolean result = loginValidator.validatePassword("");
        assertFalse(result);
    }

    @Test
    void nullPassword() {
        boolean result = loginValidator.validatePassword("");
        assertFalse(result);
    }


}