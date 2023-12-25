package test.java.paramstests;

import main.java.AgeRestrictionValidator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgeRestrictionValidatorTest {

    private AgeRestrictionValidator age;
    public static int numberOfTestCases = 0;

    @BeforeAll
    static void setup() {
        System.out.println("==>Test Started<==");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("==>Test Finished<==");
    }

    @BeforeEach
    void startTestCases() {
        numberOfTestCases++;
        age = new AgeRestrictionValidator();
        System.out.println("Test Case " + numberOfTestCases + " Started");

    }

    @AfterEach
    void closeTestCases() {
        System.out.println("Test Case " + numberOfTestCases + " Finished");
        System.out.println("-----------------------");
    }

    @ParameterizedTest
    @ValueSource(ints = {17, 66, 100, 0})
    void TestAgeRestrictionValidatorWithInvalidAge(int input) {
        boolean result = age.isEligible(input);
        assertFalse(result, "Input : " + input + "\nMethod Rule : " +
                "18 <= input <= 65\nTC_" + numberOfTestCases + " Failed");
    }

    @ParameterizedTest
    @ValueSource(ints = {18, 19, 64, 65})
    void TestAgeRestrictionValidatorWithValidAges(int input) {
        boolean result = age.isEligible(input);
        assertTrue(result, "Input : " + input + "\nMethod Rule " +
                "18 <= input <=65\nTC_" + numberOfTestCases + " Failed");
    }


}
