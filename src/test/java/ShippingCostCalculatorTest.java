package test.java;

import main.java.ShippingCostCalculator;
import org.junit.jupiter.api.Test;

import static main.java.ShippingCostCalculator.*;
import static org.junit.jupiter.api.Assertions.*;

public class ShippingCostCalculatorTest {
    ShippingCostCalculator calculator = new ShippingCostCalculator();

    // this test is for decision table test

    @Test
    void localDestinationWithStandartDelivery() {
        double weight = 2.0;
        String destination = "Local";
        String deliverySpeed = "Standard";

        double expectedCost = weight * LOCAL_RATE * STANDARD_RATE;
        double actualCost = calculator.calculateCost(weight, destination, deliverySpeed);
        assertEquals(expectedCost, actualCost);
    }

    @Test
    public void testLocalDestinationWithExpressDelivery() {
        double weight = 200000.0;
        String destination = "Local";
        String deliverySpeed = "Express";

        double expectedCost = weight * LOCAL_RATE * EXPRESS_RATE;
        double actualCost = calculator.calculateCost(weight, destination, deliverySpeed);
        assertEquals(expectedCost, actualCost);
    }

    @Test
    void testInternationalDestinationWithStandardDelivery() {
        double weight = 1000000;
        String destination = "International";
        String deliverySpeed = "Standart";

        double expectedCost = weight * INTERNATIONAL_RATE * STANDARD_RATE;
        double actualCost = calculator.calculateCost(weight, destination, deliverySpeed);
        assertEquals(expectedCost, actualCost);
    }

    @Test
    void testInternationalDestinationWithExpressdDelivery() {
        double weight = 1000000;
        String destination = "International";
        String deliverySpeed = "Express";

        double expectedCost = weight * INTERNATIONAL_RATE * EXPRESS_RATE;
        double actualCost = calculator.calculateCost(weight, destination, deliverySpeed);
        assertEquals(expectedCost, actualCost);
    }

    @Test
    void zeroWeightLocalStandartDelivery() {
        double weight = 0.0;
        String destination = "Local";
        String deliverySpeed = "Standard";

        double expectedCost = weight * LOCAL_RATE * STANDARD_RATE;
        double actualCost = calculator.calculateCost(weight, destination, deliverySpeed);

        assertEquals(expectedCost, actualCost);
    }

    @Test
    void zeroWeightLocalExpressDelivery() {
        double weight = 0.0;
        String destination = "Local";
        String deliverySpeed = "Express";

        double expectedCost = weight * LOCAL_RATE * EXPRESS_RATE;
        double actualCost = calculator.calculateCost(weight, destination, deliverySpeed);
        assertEquals(expectedCost, actualCost);
    }

    @Test
    void zeroWeightInternationalStandardDelivery() {
        double weight = 0.0;
        String destination = "International";
        String deliverySpeed = "Standart";

        double expectedCost = weight * INTERNATIONAL_RATE * STANDARD_RATE;
        double actualCost = calculator.calculateCost(weight, destination, deliverySpeed);
        assertEquals(expectedCost, actualCost);
    }

    @Test
    void zeroWeightInternationalExpressDelivery() {
        double weight = 0.0;
        String destination = "International";
        String deliverySpeed = "Express";

        double expectedCost = weight * INTERNATIONAL_RATE * EXPRESS_RATE;
        double actualCost = calculator.calculateCost(weight, destination, deliverySpeed);
        assertEquals(expectedCost, actualCost);
    }

    @Test
    void negativeWeightLocalStandartDelivery() {
        double weight = 23;
        String destination = "Local";
        String deliverySpeed = "Standard";

        double expectedCost = -23 * LOCAL_RATE * STANDARD_RATE;
        double actualCost = calculator.calculateCost(weight, destination, deliverySpeed);
        assertEquals(expectedCost, actualCost);
    }

    @Test
    void negativeWeightLocalExpressDelivery() {
        double weight = 19;
        String destination = "Local";
        String deliverySpeed = "Express";

        double expectedCost = -19 * LOCAL_RATE * EXPRESS_RATE;
        double actualCost = calculator.calculateCost(weight, destination, deliverySpeed);
        assertEquals(expectedCost, actualCost);
    }

    @Test
    void negativeWeightInternationalStandardDelivery() {
        double weight = 23;
        String destination = "International";
        String deliverySpeed = "Standart";

        double expectedCost = -23 * INTERNATIONAL_RATE * STANDARD_RATE;
        double actualCost = calculator.calculateCost(weight, destination, deliverySpeed);
        assertEquals(expectedCost, actualCost);
    }

    @Test
    void negativeWeightInternationalExpressDelivery() {
        double weight = 17.0;
        String destination = "International";
        String deliverySpeed = "Express";

        double expectedCost = -17 * INTERNATIONAL_RATE * EXPRESS_RATE;
        double actualCost = calculator.calculateCost(weight, destination, deliverySpeed);
        assertEquals(expectedCost, actualCost);
    }


}
