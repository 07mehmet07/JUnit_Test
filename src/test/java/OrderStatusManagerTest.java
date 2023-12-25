package test.java;


import main.java.OrderStatusManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderStatusManagerTest {

    OrderStatusManager manager = new OrderStatusManager();

// This test is for State Transition


    @Test
    public void testTransitionFromNewToPending() {

        OrderStatusManager.OrderState initialState = OrderStatusManager.OrderState.NEW;
        OrderStatusManager.OrderState nextState = manager.nextState(initialState);
        assertEquals(OrderStatusManager.OrderState.PENDING, nextState, "State should transition from NEW to PENDING");
    }

    @Test
    void testTransitionFromPendingToShipped() {
        OrderStatusManager.OrderState initialState = OrderStatusManager.OrderState.PENDING;
        OrderStatusManager.OrderState nextState = manager.nextState(initialState);
        assertEquals(OrderStatusManager.OrderState.SHIPPED, nextState, "State should transition from PENDING to SHIPPED");
    }

    @Test
    void testTransitionFromShippedToDelivered() {
        OrderStatusManager.OrderState initialState = OrderStatusManager.OrderState.SHIPPED;
        OrderStatusManager.OrderState nextState = manager.nextState(initialState);
        assertEquals(OrderStatusManager.OrderState.DELIVERED, nextState, "State should transition from SHIPPED to DELIVERED");
    }

    @Test
    void testNoTransitionFromDelivered() {
        OrderStatusManager.OrderState initialState = OrderStatusManager.OrderState.DELIVERED;
        OrderStatusManager.OrderState nextState = manager.nextState(initialState);
        assertEquals(OrderStatusManager.OrderState.DELIVERED, nextState, "State can not make transition from DELIVERED");
    }

    @Test
    void testNoTransitionFromCancelled() {
        OrderStatusManager.OrderState initialState = OrderStatusManager.OrderState.CANCELLED;
        OrderStatusManager.OrderState nextState = manager.nextState(initialState);
        assertEquals(OrderStatusManager.OrderState.CANCELLED, nextState, "State can not make transition from CANCELLED");
    }

    @Test
    void testCancelFromNewState() {
        OrderStatusManager.OrderState initialState = OrderStatusManager.OrderState.NEW;
        OrderStatusManager.OrderState nextState = manager.cancelOrder(initialState);
        assertEquals(OrderStatusManager.OrderState.CANCELLED, nextState, "State can make Cancellation from New");
    }

    @Test
    void testCancelFromPendingState() {
        OrderStatusManager.OrderState initialState = OrderStatusManager.OrderState.PENDING;
        OrderStatusManager.OrderState nextState = manager.cancelOrder(initialState);
        assertEquals(OrderStatusManager.OrderState.CANCELLED, nextState, "State can make Cancellation from Pending");
    }

    @Test
    void testNoCancellationFromShippedStatus() {
        OrderStatusManager.OrderState initialState = OrderStatusManager.OrderState.SHIPPED;
        OrderStatusManager.OrderState nextState = manager.cancelOrder(initialState);
        assertEquals(OrderStatusManager.OrderState.SHIPPED, nextState, "State can not make Cancellation from Shipped");
    }

    @Test
    void testNoCancellationFromDeliveredStatus() {
        OrderStatusManager.OrderState initialState = OrderStatusManager.OrderState.DELIVERED;
        OrderStatusManager.OrderState nextState = manager.cancelOrder(initialState);
        assertEquals(OrderStatusManager.OrderState.DELIVERED, nextState, "State can not make Cancellation from Delivered");
    }

    @Test
    void testNoCancellationFromCancelledStatus() {
        OrderStatusManager.OrderState initialState = OrderStatusManager.OrderState.CANCELLED;
        OrderStatusManager.OrderState nextState = manager.cancelOrder(initialState);
        assertEquals(OrderStatusManager.OrderState.CANCELLED, nextState, "You can not make Cancellation for Cancelled State");
    }


}
