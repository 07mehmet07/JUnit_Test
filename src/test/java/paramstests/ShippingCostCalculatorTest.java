package test.java.paramstests;


import main.java.ShippingCostCalculator2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShippingCostCalculatorTest {
    private ShippingCostCalculator2 calculator;

    @BeforeAll
    static void setUp() {
        System.out.println("==>TEST STARTED!<==");
    }

    @BeforeEach
    void startTestCase() {
        System.out.println("Test Case Started!");
        calculator = new ShippingCostCalculator2();
    }

    @AfterEach
    void finishTestCase() {
        System.out.println("Test Case Finished!");
        calculator = null;
        System.out.println("----------------------");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("==>TEST FINISHED!<==");
    }

    @Test
    void testShippingCostForNegativeWeightForLocalDestinationWithStandardDelivery() throws Exception {
        assertThrows(Exception.class, () -> {
            double result = calculator.calculateCost(-1, "Local", "Standard");
        });
    }

    @Test
    void testShippingCostForNegativeWeightForLocalDestinationWithExpressDelivery() {
        assertThrows(Exception.class, () -> {
            double result = calculator.calculateCost(-1, "Local", "Express");
        });
    }

    @Test
    void testShippingCostForNegativeWeightForInternationalDestinationWithStandardDelivery() throws Exception {
        assertThrows(Exception.class, () -> {
            double result = calculator.calculateCost(-1, "International", "Standard");
        });
    }

    @Test
    void testShippingCostForNegativeWeightForInternationalDestinationWithExpressDelivery() throws Exception {
        assertThrows(Exception.class, () -> {
            double result = calculator.calculateCost(-1, "International", "Express");
        });
    }

    @ParameterizedTest
    @CsvSource({"0, Local, Express",
            "0, International, Standard",
            "0, Local, Standard",
            "0, International, Express"})
    void Test(double weight, String destination, String deliverySpeed) throws Exception {
        assertThrows(Exception.class, () -> {
            calculator.calculateCost(weight, destination, deliverySpeed);
        });
    }

    @ParameterizedTest
    @CsvSource({"1, Local, Express, 2.5",
            "2, Local, Standard, 2",
            "2, International, Standard, 10",
            "2, International, Express, 25"})
    void Test1(double weight, String destination, String deliverSpeed, double expectedResult) throws Exception {
        assertEquals(expectedResult, calculator.calculateCost(weight, destination, deliverSpeed));
    }
}
