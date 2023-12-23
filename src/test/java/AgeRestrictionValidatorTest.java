package test.java;

import main.java.AgeRestrictionValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AgeRestrictionValidatorTest {
    AgeRestrictionValidator ageRestrictionValidator = new AgeRestrictionValidator();

    // this test is for boundry value analysis

    @Test
    void ageJustBelowMinimum() {
        boolean result = ageRestrictionValidator.isEligible(17);
        assertFalse(result);
    }

    @Test
    void ageAtMinimumBoundry() {
        boolean result = ageRestrictionValidator.isEligible(18);
        assertTrue(result);
    }

    @Test
    void ageJustAboveMinimum() {
        boolean result = ageRestrictionValidator.isEligible(19);
        assertTrue(result);
    }

    @Test
    void ageJustBelowMaxsimum() {
        boolean result = ageRestrictionValidator.isEligible(64);
        assertTrue(result);
    }

    @Test
    void ageAtMaxsimumBoundary() {
        boolean result = ageRestrictionValidator.isEligible(65);
        assertTrue(result);
    }

    @Test
    void ageJustAboveMaxsimum() {
        boolean result = ageRestrictionValidator.isEligible(66);
        assertFalse(result);
    }

    @Test
    void extremLowAge() {
        boolean result = ageRestrictionValidator.isEligible(0);
        assertFalse(result);
    }

    @Test
    void extremHighAge() {
        boolean result = ageRestrictionValidator.isEligible(100);
        assertFalse(result);
    }
}
