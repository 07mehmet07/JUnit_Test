package test.java.paramstests;

import main.java.OrderStatusManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderStatusManagerTest {
    private OrderStatusManager manager;
    static int numberOfTestCase = 0;

    @BeforeAll
    static void setUp() {
        System.out.println("==>Test Started<==");
    }

    @BeforeEach
    void startTestCase() {
        numberOfTestCase++;
        System.out.println("Test Case " + numberOfTestCase + " Started");
        manager = new OrderStatusManager();
    }

    @Test
    void testNoTransitionFromDeliveredStep() {
        OrderStatusManager.OrderState result = manager.nextState(OrderStatusManager.OrderState.DELIVERED);
        assertEquals(OrderStatusManager.OrderState.DELIVERED, result);
    }

    @Test
    void testNoTransitionFromCancelledStep() {
        OrderStatusManager.OrderState result = manager.nextState(OrderStatusManager.OrderState.CANCELLED);
        assertEquals(OrderStatusManager.OrderState.CANCELLED, result);
    }

    @ParameterizedTest
    @CsvSource({"NEW , PENDING",
            "PENDING, SHIPPED",
            "SHIPPED, DELIVERED"})
    void testTransitionOfNextState(OrderStatusManager.OrderState input, OrderStatusManager.OrderState expectedResult) {
        OrderStatusManager.OrderState result = manager.nextState(input);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({"NEW, CANCELLED",
            "PENDING, CANCELLED",
            "SHIPPED, SHIPPED",
            "DELIVERED, DELIVERED",
            "CANCELLED, CANCELLED"})
    void testCancelOrderMethodForOrderSteps(OrderStatusManager.OrderState input, OrderStatusManager.OrderState expectedResult) {
        assertEquals(expectedResult, manager.cancelOrder(input));
    }

    @AfterEach
    void finisTestCase() {
        System.out.println("Test Case " + numberOfTestCase + " Finished");
        manager = null;
        System.out.println("---------------------");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("==>Test Finished<==");
    }

}
